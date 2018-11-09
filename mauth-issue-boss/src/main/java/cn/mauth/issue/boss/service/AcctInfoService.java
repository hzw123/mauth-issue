package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.AcctInfoQO;
import cn.mauth.issue.boss.bean.vo.AcctInfoVO;
import cn.mauth.issue.common.dao.AcctInfoDao;
import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.example.AcctInfoExample;
import cn.mauth.issue.common.example.AcctInfoExample.Criteria;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

/**
 * 账户信息
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class AcctInfoService {

	@Autowired
	private AcctInfoDao dao;

	public Page<AcctInfoVO> listForPage(int pageCurrent, int pageSize, AcctInfoQO qo) {
		AcctInfoExample example = new AcctInfoExample();
		Criteria c = example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

		example.setOrderByClause(" id desc ");
		Page<AcctInfo> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, AcctInfoVO.class);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public AcctInfoVO getById(Long id) {
		AcctInfoVO vo = new AcctInfoVO();
		AcctInfo record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(AcctInfoQO qo) {
		AcctInfo record = new AcctInfo();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

}
