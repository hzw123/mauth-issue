package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SysMenu;
import cn.mauth.issue.common.example.SysMenuExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysMenuDao {
	Long save(SysMenu record);

	int deleteById(Long id);

	int updateById(SysMenu record);

	SysMenu getById(Long id);

	Page<SysMenu> listForPage(int pageCurrent, int pageSize, SysMenuExample example);

	List<SysMenu> listByPlatformId(Long platformId);

	List<SysMenu> listByParentId(Long id);

	List<SysMenu> listByParentIdAndPlatformId(Long parentId, Long platformId);
}
