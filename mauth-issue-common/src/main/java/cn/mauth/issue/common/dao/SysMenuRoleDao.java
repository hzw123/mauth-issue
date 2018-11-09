package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SysMenuRole;
import cn.mauth.issue.common.example.SysMenuRoleExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysMenuRoleDao {
    int save(SysMenuRole record);

    int deleteById(Long id);

    int updateById(SysMenuRole record);

    SysMenuRole getById(Long id);

    Page<SysMenuRole> listForPage(int pageCurrent, int pageSize, SysMenuRoleExample example);

	List<SysMenuRole> listByRoleId(Long roleId);

	int deleteByRoleId(Long roleId);
}
