package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.common.example.SysLogLoginExample;
import cn.mauth.issue.common.mapper.SysLogLoginMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import cn.mauth.issue.common.dao.SysLogLoginDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysLogLoginDaoImpl implements SysLogLoginDao {
    @Autowired
    private SysLogLoginMapper mapper;

    @Override
    public List<SysLogLogin> findAll() {
        return mapper.findAll();
    }

    public int save(SysLogLogin record) {
        return this.mapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.mapper.deleteByPrimaryKey(id);
    }

    public int updateById(SysLogLogin record) {
        return this.mapper.updateByPrimaryKeySelective(record);
    }

    public SysLogLogin getLastSysLogLogin(Long userId){
        return mapper.getLastSysLogLogin(userId);
    }

    @Override
    public SysLogLogin getLastSysLogLoginOfSingleName(String singleName) {
        return mapper.getLastSysLogLoginOfSingleName(singleName);
    }

    public SysLogLogin getById(Long id) {
        return this.mapper.selectByPrimaryKey(id);
    }

    public Page<SysLogLogin> listForPage(int pageCurrent, int pageSize, SysLogLoginExample example) {
        int count = this.mapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<>(count, totalPage, pageCurrent, pageSize, this.mapper.selectByExample(example));
    }
}
