package cn.mauth.issue.common.dao.impl;

import java.util.List;

import cn.mauth.issue.common.entity.SysRole;
import cn.mauth.issue.common.example.SysRoleExample;
import cn.mauth.issue.common.mapper.SysRoleMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.SysRoleDao;

@Repository
public class SysRoleDaoImpl implements SysRoleDao {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
	public int save(SysRole record) {
        return this.sysRoleMapper.insertSelective(record);
    }

    @Override
	public int deleteById(Long id) {
        return this.sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
	public int updateById(SysRole record) {
        return this.sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
	public SysRole getById(Long id) {
        return this.sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
	public Page<SysRole> listForPage(int pageCurrent, int pageSize, SysRoleExample example) {
        int count = this.sysRoleMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<SysRole>(count, totalPage, pageCurrent, pageSize, this.sysRoleMapper.selectByExample(example));
    }

	@Override
	public List<SysRole> listByExample(SysRoleExample example) {
		return this.sysRoleMapper.selectByExample(example);
	}
}
