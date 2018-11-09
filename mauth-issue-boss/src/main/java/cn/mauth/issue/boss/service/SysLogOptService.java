package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.SysLogOptQO;
import cn.mauth.issue.boss.bean.vo.SysLogOptVO;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.common.dao.SysLogOptDao;
import cn.mauth.issue.common.entity.SysLogOpt;
import cn.mauth.issue.common.example.SysLogOptExample;
import cn.mauth.issue.common.example.SysLogOptExample.Criteria;

import java.util.Date;

/**
 * 用户操作日志表 
 *
 * @author mauth
 * @since 2017-12-26
 */
@Component
public class SysLogOptService {

	@Autowired
	private SysLogOptDao dao;

	public Page<SysLogOptVO> listForPage(int pageCurrent, int pageSize, SysLogOptQO qo) {
	    SysLogOptExample example = new SysLogOptExample();
	    Criteria c = example.createCriteria();

	    /** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

	    example.setOrderByClause(" id desc ");
        Page<SysLogOpt> page = dao.listForPage(pageCurrent, pageSize, example);
        return PageUtil.transform(page, SysLogOptVO.class);
	}

	public int save(SysLogOptQO qo) {
	    SysLogOpt record = new SysLogOpt();
        BeanUtils.copyProperties(qo, record);
        record.setGmtCreate(new Date());
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public SysLogOptVO getById(Long id) {
	    SysLogOptVO vo = new SysLogOptVO();
	    SysLogOpt record = dao.getById(id);
        BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(SysLogOptQO qo) {
	    SysLogOpt record = new SysLogOpt();
        BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}
	
}
