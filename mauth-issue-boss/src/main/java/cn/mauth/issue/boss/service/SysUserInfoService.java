package cn.mauth.issue.boss.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.SysUserInfoQO;
import cn.mauth.issue.boss.bean.vo.SysUserInfoVO;
import cn.mauth.issue.common.dao.AcctInfoDao;
import cn.mauth.issue.common.dao.MerchantInfoDao;
import cn.mauth.issue.common.dao.SysUserInfoDao;
import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.entity.MerchantInfo;
import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.common.example.SysUserInfoExample;
import cn.mauth.issue.common.example.SysUserInfoExample.Criteria;
import cn.mauth.issue.util.Constants;
import cn.mauth.issue.util.VCUtil;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.ApiVerifyTypeEnum;
import cn.mauth.issue.util.enums.PriceLevelEnum;
import cn.mauth.issue.util.enums.StatusIdEnum;
import cn.mauth.issue.util.enums.UserTypeEnum;
import com.xiaoleilu.hutool.crypto.DigestUtil;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;

/**
 * 后台用户信息
 *
 * @author mauth
 * @since 2017-12-26
 */
@Component
public class SysUserInfoService {

	@Autowired
	private SysUserInfoDao dao;
	@Autowired
	private MerchantInfoDao merchantInfoDao;
	@Autowired
	private AcctInfoDao acctInfoDao;

	public Page<SysUserInfoVO> listForPage(int pageCurrent, int pageSize, SysUserInfoQO qo) {
		SysUserInfoExample example = new SysUserInfoExample();
		Criteria c = example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andIdEqualTo(SessionUtils.getUserInfoId());
		}else{
			if (StringUtils.isNotBlank(qo.getLoginName())) {
				c.andLoginNameLike(PageUtil.likeRight(qo.getLoginName()));
			}
			if (StringUtils.isNotBlank(qo.getMobile())) {
				c.andMobileLike(PageUtil.likeRight(qo.getMobile()));
			}
			if (ObjectUtil.isNotNull(qo.getUserType())) {
				c.andUserTypeEqualTo(qo.getUserType());
			}
		}

		example.setOrderByClause(" id desc ");
		Page<SysUserInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, SysUserInfoVO.class);
	}

	public int save(SysUserInfoQO qo) {
		SysUserInfo record = new SysUserInfo();
		BeanUtils.copyProperties(qo, record);
		record.setStatusId(StatusIdEnum.NORMAL.getCode()); // 默认正常状态
		record.setSalt(SecureUtil.simpleUUID());
		record.setPwd(DigestUtil.md5Hex(record.getSalt() + qo.getPwd()));
		Long userInfoId = dao.save(record);

		// 下游用户
		if (record.getUserType().equals(UserTypeEnum.MERCHANTS.getCode())) {
			// 账号
			AcctInfo acctInfo = new AcctInfo();
			acctInfo.setStatusId(StatusIdEnum.NORMAL.getCode());
			acctInfo.setUserInfoId(userInfoId);
			acctInfo.setTotalBalance(0L);
			acctInfo.setLastTradeBalance(0L);
			acctInfo.setLastTradeDate(new Date());
			acctInfo.setVerificationCode(VCUtil.getVC(acctInfo.getTotalBalance(), acctInfo.getLastTradeBalance()));
			Long acctInfoId = acctInfoDao.save(acctInfo);

			// 下游
			MerchantInfo merchantInfo = new MerchantInfo();
			merchantInfo.setAppId("RC" + SecureUtil.simpleUUID());
			merchantInfo.setAppSeceret(SecureUtil.simpleUUID());
			merchantInfo.setUserInfoId(userInfoId);
			merchantInfo.setAcctInfoId(acctInfoId);
			merchantInfo.setPriceLevel(PriceLevelEnum.ONE.getCode());
			merchantInfo.setApiVerifyType(ApiVerifyTypeEnum.SECRET.getCode());
			merchantInfoDao.save(merchantInfo);
		}

		return 1;
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public SysUserInfoVO getById(Long id) {
		SysUserInfoVO vo = new SysUserInfoVO();
		SysUserInfo record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(SysUserInfoQO qo) {
		SysUserInfo record = new SysUserInfo();
		BeanUtils.copyProperties(qo, record);
		record.setLoginName(null); // 登录名不能修改
		return dao.updateById(record);
	}

	public Page<SysUserInfoVO> lookup(int pageCurrent, int pageSize, SysUserInfoQO qo) {
		SysUserInfoExample example = new SysUserInfoExample();
		Criteria c = example.createCriteria();
		c.andUserTypeEqualTo(UserTypeEnum.MERCHANTS.getCode());
		List<Long> listIds = getIds();
		if (!listIds.isEmpty()) {
			c.andIdNotIn(listIds); // 已经绑定的用户不再列出，防止重复
		}
		example.setOrderByClause(" id desc ");
		Page<SysUserInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, SysUserInfoVO.class);
	}

	private List<Long> getIds() {
		List<Long> ids = new ArrayList<>();
		List<MerchantInfo> listMch = merchantInfoDao.listAll();
		if (listMch != null && !listMch.isEmpty()) {
			for (MerchantInfo mch : listMch) {
				ids.add(mch.getUserInfoId());
			}
		}
		return ids;
	}

	public SysUserInfoVO getUserInfoForSeesion() {
		Long userInfoId = Long.valueOf(SessionUtils.getAttribute(Constants.Session.USER_ID).toString());
		return getById(userInfoId);
	}

	public int updatePassword(String oldPwd, String newPwd, String rePwd) {
		Long userInfoId = Long.valueOf(SessionUtils.getAttribute(Constants.Session.USER_ID).toString());
		SysUserInfo sysUserInfo = dao.getById(userInfoId);
		if (!newPwd.equals(rePwd)) {
			return -1;
		}

		if (sysUserInfo.getPwd().equals(DigestUtil.md5Hex(sysUserInfo.getSalt() + oldPwd))) {
			SysUserInfo user = new SysUserInfo();
			user.setSalt(SecureUtil.simpleUUID());
			user.setPwd(DigestUtil.md5Hex(user.getSalt() + newPwd));
			user.setId(userInfoId);
			return dao.updateById(user);
		}
		return -1;
	}

}
