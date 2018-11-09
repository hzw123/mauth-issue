package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SysRole;
import cn.mauth.issue.common.example.SysRoleExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysRoleDao {
    int save(SysRole record);

    int deleteById(Long id);

    int updateById(SysRole record);

    SysRole getById(Long id);

    Page<SysRole> listForPage(int pageCurrent, int pageSize, SysRoleExample example);

	List<SysRole> listByExample(SysRoleExample example);
}
