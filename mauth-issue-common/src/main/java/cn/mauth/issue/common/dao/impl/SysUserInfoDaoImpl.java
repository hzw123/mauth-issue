package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.common.example.SysUserInfoExample;
import cn.mauth.issue.common.mapper.SysUserInfoMapper;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.SysUserInfoDao;

@Repository
public class SysUserInfoDaoImpl extends AbstractBaseJdbc implements SysUserInfoDao {
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;

	@Override
	public Long save(SysUserInfo record) {
		this.sysUserInfoMapper.insertSelective(record);
		return getLastId();
	}

	@Override
	public int deleteById(Long id) {
		return this.sysUserInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(SysUserInfo record) {
		return this.sysUserInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SysUserInfo getById(Long id) {
		return this.sysUserInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<SysUserInfo> listForPage(int pageCurrent, int pageSize, SysUserInfoExample example) {
		int count = this.sysUserInfoMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<SysUserInfo>(count, totalPage, pageCurrent, pageSize, this.sysUserInfoMapper.selectByExample(example));
	}

	@Override
	public SysUserInfo getByLoginName(String username) {
		return this.sysUserInfoMapper.findByUsername(username);
	}
}
