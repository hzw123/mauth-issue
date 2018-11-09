package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.AreaInfo;
import cn.mauth.issue.common.example.AreaInfoExample;
import cn.mauth.issue.util.bjui.Page;

public interface AreaInfoDao {
	int save(AreaInfo record);

	int deleteById(Long id);

	int updateById(AreaInfo record);

	AreaInfo getById(Long id);

	Page<AreaInfo> listForPage(int pageCurrent, int pageSize, AreaInfoExample example);

	AreaInfo getByProvinceCode(String provinceCode);

	AreaInfo getByProvinceAndCity(String provinceName, String cityName);

	List<AreaInfo> listByAreaType(int areaType);
}
