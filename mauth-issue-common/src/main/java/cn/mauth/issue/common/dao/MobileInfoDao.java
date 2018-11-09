package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.MobileInfo;
import cn.mauth.issue.common.example.MobileInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface MobileInfoDao {
    int save(MobileInfo record);

    int deleteById(Long id);

    int updateById(MobileInfo record);

    MobileInfo getById(Long id);

    Page<MobileInfo> listForPage(int pageCurrent, int pageSize, MobileInfoExample example);

	MobileInfo getByMobilePrefix(String mobilePrefix);
}
