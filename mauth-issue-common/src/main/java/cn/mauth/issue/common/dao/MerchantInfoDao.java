package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.MerchantInfo;
import cn.mauth.issue.common.example.MerchantInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface MerchantInfoDao {
    int save(MerchantInfo record);

    int deleteById(Long id);

    int updateById(MerchantInfo record);

    MerchantInfo getById(Long id);

    Page<MerchantInfo> listForPage(int pageCurrent, int pageSize, MerchantInfoExample example);

	MerchantInfo getByAppId(String appId);

	List<MerchantInfo> listAll();
}
