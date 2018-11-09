package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.example.AcctInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface AcctInfoDao {
	Long save(AcctInfo record);

	int deleteById(Long id);

	int updateById(AcctInfo record);

	AcctInfo getById(Long id);

	Page<AcctInfo> listForPage(int pageCurrent, int pageSize, AcctInfoExample example);

	AcctInfo getByUserInfoId(Long userInfoId);

	AcctInfo getByIdForUpdate(Long acctInfoId);
}
