package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SysRoleUser;
import cn.mauth.issue.common.example.SysRoleUserExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysRoleUserDao {
    int save(SysRoleUser record);

    int deleteById(Long id);

    int updateById(SysRoleUser record);

    SysRoleUser getById(Long id);

    Page<SysRoleUser> listForPage(int pageCurrent, int pageSize, SysRoleUserExample example);

	List<SysRoleUser> listByUserInfoId(Long userInfoId);

	int deleteByUserInfoId(Long userInfoId);

	List<SysRoleUser> listByUserInfoIdAndPlatformId(Long userInfoId, Long platformId);
}
