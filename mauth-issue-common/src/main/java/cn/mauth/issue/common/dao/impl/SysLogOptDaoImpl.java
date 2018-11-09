package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.entity.SysLogOpt;
import cn.mauth.issue.common.example.SysLogOptExample;
import cn.mauth.issue.common.mapper.SysLogOptMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import cn.mauth.issue.common.dao.SysLogOptDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SysLogOptDaoImpl implements SysLogOptDao {
    @Autowired
    private SysLogOptMapper sysLogOptMapper;

    public int save(SysLogOpt record) {
        return this.sysLogOptMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.sysLogOptMapper.deleteByPrimaryKey(id);
    }

    public int updateById(SysLogOpt record) {
        return this.sysLogOptMapper.updateByPrimaryKeySelective(record);
    }

    public SysLogOpt getById(Long id) {
        return this.sysLogOptMapper.selectByPrimaryKey(id);
    }

    public Page<SysLogOpt> listForPage(int pageCurrent, int pageSize, SysLogOptExample example) {
        int count = this.sysLogOptMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<SysLogOpt>(count, totalPage, pageCurrent, pageSize, this.sysLogOptMapper.selectByExample(example));
    }
}
