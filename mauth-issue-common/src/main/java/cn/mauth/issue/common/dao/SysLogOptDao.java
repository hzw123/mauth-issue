package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.SysLogOpt;
import cn.mauth.issue.common.example.SysLogOptExample;
import cn.mauth.issue.util.bjui.Page;

public interface SysLogOptDao {
    int save(SysLogOpt record);

    int deleteById(Long id);

    int updateById(SysLogOpt record);

    SysLogOpt getById(Long id);

    Page<SysLogOpt> listForPage(int pageCurrent, int pageSize, SysLogOptExample example);
}
