package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.SupplyInfo;
import cn.mauth.issue.common.example.SupplyInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface SupplyInfoDao {
    int save(SupplyInfo record);

    int deleteById(Long id);

    int updateById(SupplyInfo record);

    SupplyInfo getById(Long id);

    Page<SupplyInfo> listForPage(int pageCurrent, int pageSize, SupplyInfoExample example);

	List<SupplyInfo> listByStatusId(Integer statusId);

	SupplyInfo getBySupplyCode(String supplyCode);
}
