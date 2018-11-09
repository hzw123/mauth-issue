package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.common.example.SysLogLoginExample;
import cn.mauth.issue.util.bjui.Page;

import java.util.List;

public interface SysLogLoginDao {

    List<SysLogLogin> findAll();

    int save(SysLogLogin record);

    int deleteById(Long id);

    int updateById(SysLogLogin record);

    SysLogLogin getLastSysLogLogin(Long userId);

    SysLogLogin getLastSysLogLoginOfSingleName(String singleName);

    SysLogLogin getById(Long id);

    Page<SysLogLogin> listForPage(int pageCurrent, int pageSize, SysLogLoginExample example);
}
