package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.AcctLogQO;
import cn.mauth.issue.boss.bean.vo.AcctLogVO;
import cn.mauth.issue.common.dao.AcctLogDao;
import cn.mauth.issue.common.entity.AcctLog;
import cn.mauth.issue.common.example.AcctLogExample;
import cn.mauth.issue.common.example.AcctLogExample.Criteria;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

/**
 * 账户日志
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class AcctLogService {

	@Autowired
	private AcctLogDao dao;

	public Page<AcctLogVO> listForPage(int pageCurrent, int pageSize, AcctLogQO qo) {
		AcctLogExample example = new AcctLogExample();
		Criteria c = example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

		example.setOrderByClause(" id desc ");
		Page<AcctLog> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, AcctLogVO.class);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public AcctLogVO getById(Long id) {
		AcctLogVO vo = new AcctLogVO();
		AcctLog record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(AcctLogQO qo) {
		AcctLog record = new AcctLog();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

}
