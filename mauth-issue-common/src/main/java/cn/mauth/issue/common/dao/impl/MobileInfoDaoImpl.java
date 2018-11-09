package cn.mauth.issue.common.dao.impl;

import java.util.List;

import cn.mauth.issue.common.entity.MobileInfo;
import cn.mauth.issue.common.example.MobileInfoExample;
import cn.mauth.issue.common.mapper.MobileInfoMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.MobileInfoDao;

@Repository
public class MobileInfoDaoImpl implements MobileInfoDao {
	@Autowired
	private MobileInfoMapper mobileInfoMapper;

	@Override
	public int save(MobileInfo record) {
		return this.mobileInfoMapper.insertSelective(record);
	}

	@Override
	public int deleteById(Long id) {
		return this.mobileInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(MobileInfo record) {
		return this.mobileInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public MobileInfo getById(Long id) {
		return this.mobileInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<MobileInfo> listForPage(int pageCurrent, int pageSize, MobileInfoExample example) {
		int count = this.mobileInfoMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<MobileInfo>(count, totalPage, pageCurrent, pageSize, this.mobileInfoMapper.selectByExample(example));
	}

	@Override
	public MobileInfo getByMobilePrefix(String mobilePrefix) {
		MobileInfoExample example = new MobileInfoExample();
		example.createCriteria().andMobilePrefixEqualTo(mobilePrefix);
		List<MobileInfo> list = this.mobileInfoMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
