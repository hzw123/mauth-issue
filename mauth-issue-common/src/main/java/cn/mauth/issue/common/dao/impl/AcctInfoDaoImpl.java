package cn.mauth.issue.common.dao.impl;

import java.util.Date;
import java.util.List;

import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.example.AcctInfoExample;
import cn.mauth.issue.common.mapper.AcctInfoMapper;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.AcctInfoDao;

@Repository
public class AcctInfoDaoImpl extends AbstractBaseJdbc implements AcctInfoDao {
	@Autowired
	private AcctInfoMapper acctInfoMapper;

	@Override
	public Long save(AcctInfo record) {
		record.setGmtCreate(new Date());
		record.setGmtModified(new Date());
		this.acctInfoMapper.insertSelective(record);
		return getLastId();
	}

	@Override
	public int deleteById(Long id) {
		return this.acctInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(AcctInfo record) {
		record.setGmtModified(new Date());
		return this.acctInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public AcctInfo getById(Long id) {
		return this.acctInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<AcctInfo> listForPage(int pageCurrent, int pageSize, AcctInfoExample example) {
		int count = this.acctInfoMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<AcctInfo>(count, totalPage, pageCurrent, pageSize, this.acctInfoMapper.selectByExample(example));
	}

	@Override
	public AcctInfo getByUserInfoId(Long userInfoId) {
		AcctInfoExample example = new AcctInfoExample();
		example.createCriteria().andUserInfoIdEqualTo(userInfoId);
		List<AcctInfo> list = this.acctInfoMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public AcctInfo getByIdForUpdate(Long acctInfoId) {
		String sql = "select * from acct_info where id=? for update";
		return queryForObject(sql, AcctInfo.class, acctInfoId);
	}
}
