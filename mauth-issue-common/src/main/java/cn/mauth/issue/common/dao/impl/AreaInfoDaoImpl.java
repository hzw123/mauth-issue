package cn.mauth.issue.common.dao.impl;

import java.util.List;

import cn.mauth.issue.common.entity.AreaInfo;
import cn.mauth.issue.common.example.AreaInfoExample;
import cn.mauth.issue.common.mapper.AreaInfoMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.AreaInfoDao;

@Repository
public class AreaInfoDaoImpl implements AreaInfoDao {
	@Autowired
	private AreaInfoMapper areaInfoMapper;

	@Override
	public int save(AreaInfo record) {
		return this.areaInfoMapper.insertSelective(record);
	}

	@Override
	public int deleteById(Long id) {
		return this.areaInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(AreaInfo record) {
		return this.areaInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public AreaInfo getById(Long id) {
		return this.areaInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<AreaInfo> listForPage(int pageCurrent, int pageSize, AreaInfoExample example) {
		int count = this.areaInfoMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<AreaInfo>(count, totalPage, pageCurrent, pageSize, this.areaInfoMapper.selectByExample(example));
	}

	@Override
	public AreaInfo getByProvinceCode(String provinceCode) {
		AreaInfoExample example = new AreaInfoExample();
		example.createCriteria().andProvinceCodeEqualTo(provinceCode);
		List<AreaInfo> list = this.areaInfoMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public AreaInfo getByProvinceAndCity(String provinceName, String cityName) {
		AreaInfoExample example = new AreaInfoExample();
		example.createCriteria().andProvinceNameLike(PageUtil.likeRight(provinceName)).andCityNameLike(PageUtil.likeRight(cityName));
		List<AreaInfo> list = this.areaInfoMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<AreaInfo> listByAreaType(int areaType) {
		AreaInfoExample example = new AreaInfoExample();
		example.createCriteria().andAreaTypeEqualTo(areaType);
		return this.areaInfoMapper.selectByExample(example);
	}
}
