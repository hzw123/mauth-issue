package cn.mauth.issue.boss.service;

import java.util.Date;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.mauth.issue.boss.bean.qo.MerchantInfoQO;
import cn.mauth.issue.boss.bean.vo.MerchantInfoVO;
import cn.mauth.issue.common.dao.AcctInfoDao;
import cn.mauth.issue.common.dao.MerchantInfoDao;
import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.entity.MerchantInfo;
import cn.mauth.issue.common.example.MerchantInfoExample;
import cn.mauth.issue.common.example.MerchantInfoExample.Criteria;
import cn.mauth.issue.util.VCUtil;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.StatusIdEnum;
import com.xiaoleilu.hutool.crypto.SecureUtil;

/**
 * 下游商户信息服务
 *
 * @author mauth
 * @since 2017-12-22
 */
@Component
public class MerchantInfoService {

	@Autowired
	private MerchantInfoDao dao;
	@Autowired
	private AcctInfoDao acctInfoDao;

	public Page<MerchantInfoVO> listForPage(int pageCurrent, int pageSize, MerchantInfoQO qo) {
		MerchantInfoExample example = new MerchantInfoExample();
		Criteria c=example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

		example.setOrderByClause(" id desc ");
		Page<MerchantInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, MerchantInfoVO.class);
	}

	/**
	 * 添加商户，同时添加账户
	 */
	@Transactional
	public int save(MerchantInfoQO qo) {
		AcctInfo acctInfo = new AcctInfo();
		acctInfo.setStatusId(StatusIdEnum.NORMAL.getCode());
		acctInfo.setUserInfoId(qo.getUserInfoId());
		acctInfo.setTotalBalance(0L);
		acctInfo.setLastTradeBalance(0L);
		acctInfo.setLastTradeDate(new Date());
		acctInfo.setVerificationCode(VCUtil.getVC(acctInfo.getTotalBalance(), acctInfo.getLastTradeBalance()));
		acctInfoDao.save(acctInfo);
		acctInfo = acctInfoDao.getByUserInfoId(qo.getUserInfoId());

		MerchantInfo record = new MerchantInfo();
		BeanUtils.copyProperties(qo, record);
		record.setAppId("RC" + SecureUtil.simpleUUID());
		record.setAppSeceret(SecureUtil.simpleUUID());
		record.setAcctInfoId(acctInfo.getId());

		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public MerchantInfoVO getById(Long id) {
		MerchantInfoVO vo = new MerchantInfoVO();
		MerchantInfo record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		AcctInfo acctInfo = acctInfoDao.getById(record.getAcctInfoId());
		vo.setTotalBalance(acctInfo.getTotalBalance());
		return vo;
	}

	public int updateById(MerchantInfoQO qo) {
		MerchantInfo record = new MerchantInfo();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

}
