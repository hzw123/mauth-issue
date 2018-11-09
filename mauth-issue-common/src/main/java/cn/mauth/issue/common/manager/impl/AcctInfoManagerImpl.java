package cn.mauth.issue.common.manager.impl;

import java.util.Date;

import cn.mauth.issue.util.VCUtil;
import cn.mauth.issue.util.base.BaseRoncoo;
import cn.mauth.issue.util.enums.BillStatusEnum;
import cn.mauth.issue.util.enums.BillTypeEnum;
import cn.mauth.issue.util.enums.StatusIdEnum;
import cn.mauth.issue.util.enums.TradeTypeEnum;
import cn.mauth.issue.util.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mauth.issue.common.dao.AcctInfoDao;
import cn.mauth.issue.common.dao.AcctLogDao;
import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.entity.AcctLog;
import cn.mauth.issue.common.entity.OrderTradePay;
import cn.mauth.issue.common.manager.AcctInfoManager;

@Component
public class AcctInfoManagerImpl extends BaseRoncoo implements AcctInfoManager {

	@Autowired
	private AcctInfoDao acctInfoDao;
	@Autowired
	private AcctLogDao acctLogDao;

	/**
	 * 事务操作
	 */
	@Override
	@Transactional
	public AcctInfo commitBalance(OrderTradePay orderTradePay) {
		AcctInfo acctInfo = acctInfoDao.getByIdForUpdate(orderTradePay.getAcctInfoId());
		// 注意：抛出异常才会执行 rollback 释放掉上面的锁

		// 账户校验
		if (!acctInfo.getStatusId().equals(StatusIdEnum.NORMAL.getCode())) {
			throw new BaseException("无法交易，账户被冻结");
		}

		if (!VCUtil.checkVC(acctInfo.getVerificationCode(), acctInfo.getTotalBalance(), acctInfo.getLastTradeBalance())) {
			throw new BaseException("无法交易，账户异常");
		}

		Long totalBalance = 0L;
		if (orderTradePay.getTradeType().equals(TradeTypeEnum.ADD.getCode())) {
			// 增加
			totalBalance = acctInfo.getTotalBalance() + orderTradePay.getSalesPrice();
		} else if (orderTradePay.getTradeType().equals(TradeTypeEnum.SUBTRACT.getCode())) {
			// 金额处理
			totalBalance = acctInfo.getTotalBalance() - orderTradePay.getSalesPrice();
			if (totalBalance < 0) {
				logger.warn("账户余额不足：acctInfoId={}, paySerialNo={}", acctInfo.getId(), orderTradePay.getPaySerialNo());
				throw new BaseException("账户余额不足");
			}
		} else {
			logger.error("未知交易类型");
			throw new BaseException("无法交易，数据异常");
		}

		// 更新账户
		updateAcctInfo(acctInfo, totalBalance);

		// 创建账户记录
		Long acctLogId = saveAcctLog(orderTradePay, acctInfo);
		orderTradePay.setAcctLogId(acctLogId);

		return acctInfo;
	}

	private Long saveAcctLog(OrderTradePay orderTradePay, AcctInfo acctInfo) {
		AcctLog acctLog = new AcctLog();
		acctLog.setUserInfoId(acctInfo.getUserInfoId());
		acctLog.setAcctInfoId(acctInfo.getId());
		acctLog.setBillType(BillTypeEnum.PAY.getCode());
		acctLog.setBillStatus(BillStatusEnum.SUCCESS.getCode());
		acctLog.setTradeType(orderTradePay.getTradeType());
		acctLog.setPaySerialNo(orderTradePay.getPaySerialNo());
		acctLog.setAmount(orderTradePay.getSalesPrice());
		acctLog.setTotalBalance(acctInfo.getTotalBalance());
		return acctLogDao.save(acctLog);
	}

	private void updateAcctInfo(AcctInfo acctInfo, Long totalBalance) {
		acctInfo.setLastTradeBalance(acctInfo.getTotalBalance());
		acctInfo.setLastTradeDate(new Date());
		acctInfo.setTotalBalance(totalBalance);
		acctInfo.setVerificationCode(VCUtil.getVC(acctInfo.getTotalBalance(), acctInfo.getLastTradeBalance()));
		acctInfoDao.updateById(acctInfo);
	}

}
