package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.AcctLog;
import cn.mauth.issue.common.example.AcctLogExample;
import cn.mauth.issue.util.bjui.Page;

public interface AcctLogDao {
    Long save(AcctLog record);

    int deleteById(Long id);

    int updateById(AcctLog record);

    AcctLog getById(Long id);

    Page<AcctLog> listForPage(int pageCurrent, int pageSize, AcctLogExample example);
}
