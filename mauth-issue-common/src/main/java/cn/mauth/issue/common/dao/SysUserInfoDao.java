package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.common.example.SysUserInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysUserInfoDao {
	Long save(SysUserInfo record);

	int deleteById(Long id);

	int updateById(SysUserInfo record);

	SysUserInfo getById(Long id);

	Page<SysUserInfo> listForPage(int pageCurrent, int pageSize, SysUserInfoExample example);

	SysUserInfo getByLoginName(String username);
}
