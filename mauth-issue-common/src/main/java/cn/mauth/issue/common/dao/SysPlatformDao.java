package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SysPlatform;
import cn.mauth.issue.common.example.SysPlatformExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysPlatformDao {
    int save(SysPlatform record);

    int deleteById(Long id);

    int updateById(SysPlatform record);

    SysPlatform getById(Long id);

    Page<SysPlatform> listForPage(int pageCurrent, int pageSize, SysPlatformExample example);

	List<SysPlatform> listAll();

	SysPlatform getByPlatformAppid(String platformAppid);
}
