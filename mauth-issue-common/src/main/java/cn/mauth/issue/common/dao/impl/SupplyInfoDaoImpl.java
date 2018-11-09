package cn.mauth.issue.common.dao.impl;

import java.util.List;

import cn.mauth.issue.common.entity.SupplyInfo;
import cn.mauth.issue.common.example.SupplyInfoExample;
import cn.mauth.issue.common.mapper.SupplyInfoMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.SupplyInfoDao;

@Repository
public class SupplyInfoDaoImpl implements SupplyInfoDao {
	@Autowired
	private SupplyInfoMapper supplyInfoMapper;

	@Override
	public int save(SupplyInfo record) {
		return this.supplyInfoMapper.insertSelective(record);
	}

	@Override
	public int deleteById(Long id) {
		return this.supplyInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(SupplyInfo record) {
		return this.supplyInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SupplyInfo getById(Long id) {
		return this.supplyInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<SupplyInfo> listForPage(int pageCurrent, int pageSize, SupplyInfoExample example) {
		int count = this.supplyInfoMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<SupplyInfo>(count, totalPage, pageCurrent, pageSize, this.supplyInfoMapper.selectByExample(example));
	}

	@Override
	public List<SupplyInfo> listByStatusId(Integer statusId) {
		SupplyInfoExample example = new SupplyInfoExample();
		example.createCriteria().andStatusIdEqualTo(statusId);
		example.setOrderByClause(" id desc ");
		return this.supplyInfoMapper.selectByExample(example);
	}

	@Override
	public SupplyInfo getBySupplyCode(String supplyCode) {
		SupplyInfoExample example = new SupplyInfoExample();
		example.createCriteria().andSupplyCodeEqualTo(supplyCode);
		List<SupplyInfo> list = this.supplyInfoMapper.selectByExample(example);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
