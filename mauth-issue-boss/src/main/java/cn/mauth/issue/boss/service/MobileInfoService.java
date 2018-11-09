package cn.mauth.issue.boss.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.MobileInfoQO;
import cn.mauth.issue.boss.bean.vo.MobileInfoVO;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.common.dao.MobileInfoDao;
import cn.mauth.issue.common.entity.MobileInfo;
import cn.mauth.issue.common.example.MobileInfoExample;

/**
 *  
 *
 * @author mauth
 * @since 2017-12-30
 */
@Component
public class MobileInfoService {

	@Autowired
	private MobileInfoDao dao;

	public Page<MobileInfoVO> listForPage(int pageCurrent, int pageSize, MobileInfoQO qo) {
	    MobileInfoExample example = new MobileInfoExample();
//	    Criteria c = example.createCriteria();
	    example.setOrderByClause(" id desc ");
        Page<MobileInfo> page = dao.listForPage(pageCurrent, pageSize, example);
        return PageUtil.transform(page, MobileInfoVO.class);
	}

	public int save(MobileInfoQO qo) {
	    MobileInfo record = new MobileInfo();
        BeanUtils.copyProperties(qo, record);
		return dao.save(record);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public MobileInfoVO getById(Long id) {
	    MobileInfoVO vo = new MobileInfoVO();
	    MobileInfo record = dao.getById(id);
        BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(MobileInfoQO qo) {
	    MobileInfo record = new MobileInfo();
        BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}
	
}
