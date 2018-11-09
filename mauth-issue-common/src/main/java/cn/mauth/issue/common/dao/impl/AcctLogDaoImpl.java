package cn.mauth.issue.common.dao.impl;

import java.util.Date;

import cn.mauth.issue.common.entity.AcctLog;
import cn.mauth.issue.common.example.AcctLogExample;
import cn.mauth.issue.common.mapper.AcctLogMapper;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.mauth.issue.common.dao.AcctLogDao;

@Repository
public class AcctLogDaoImpl extends AbstractBaseJdbc implements AcctLogDao {
    @Autowired
    private AcctLogMapper acctLogMapper;

    @Override
	@Transactional
    public Long save(AcctLog record) {
    	record.setGmtCreate(new Date());
    	record.setGmtModified(new Date());
        this.acctLogMapper.insertSelective(record);
        return getLastId();
    }

    @Override
	public int deleteById(Long id) {
        return this.acctLogMapper.deleteByPrimaryKey(id);
    }

    @Override
	public int updateById(AcctLog record) {
    	record.setGmtModified(new Date());
        return this.acctLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
	public AcctLog getById(Long id) {
        return this.acctLogMapper.selectByPrimaryKey(id);
    }

    @Override
	public Page<AcctLog> listForPage(int pageCurrent, int pageSize, AcctLogExample example) {
        int count = this.acctLogMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<AcctLog>(count, totalPage, pageCurrent, pageSize, this.acctLogMapper.selectByExample(example));
    }
}
