package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.SysLogLoginQO;
import cn.mauth.issue.boss.bean.vo.SysLogLoginVO;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.common.dao.SysLogLoginDao;
import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.common.example.SysLogLoginExample;
import cn.mauth.issue.common.example.SysLogLoginExample.Criteria;
import org.springframework.util.StringUtils;

/**
 * 用户登陆日志 
 *
 * @author mauth
 * @since 2017-12-26
 */
@Component
public class SysLogLoginService {

	@Autowired
	private SysLogLoginDao dao;

	public Page<SysLogLoginVO> listForPage(int pageCurrent, int pageSize, SysLogLoginQO qo) {
	    SysLogLoginExample example = new SysLogLoginExample();
	    Criteria c = example.createCriteria();
	    if(!StringUtils.isEmpty(qo.getUserInfoId())){
			c.andUserInfoIdEqualTo(qo.getUserInfoId());
		}
	    if(!StringUtils.isEmpty(qo.getLastLoginIp())){
			c.andLoginIpLike(qo.getLoginIp());
		}
		if(!StringUtils.isEmpty(qo.getLoginName())){
			c.andLoginNameLike(qo.getLoginName());
		}

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

	    example.setOrderByClause(" id desc ");
        Page<SysLogLogin> page = dao.listForPage(pageCurrent, pageSize, example);
        return PageUtil.transform(page, SysLogLoginVO.class);
	}

	public int save(SysLogLoginQO qo) {
	    SysLogLogin record = new SysLogLogin();
        BeanUtils.copyProperties(qo, record);
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public SysLogLoginVO getById(Long id) {
	    SysLogLoginVO vo = new SysLogLoginVO();
	    SysLogLogin record = dao.getById(id);
        BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(SysLogLoginQO qo) {
	    SysLogLogin record = new SysLogLogin();
        BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}
	
}
