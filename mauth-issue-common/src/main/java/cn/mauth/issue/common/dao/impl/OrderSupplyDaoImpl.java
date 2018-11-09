package cn.mauth.issue.common.dao.impl;

import java.util.Date;
import java.util.List;

import cn.mauth.issue.common.entity.OrderSupply;
import cn.mauth.issue.common.example.OrderSupplyExample;
import cn.mauth.issue.common.mapper.OrderSupplyMapper;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.OrderSupplyDao;

@Repository
public class OrderSupplyDaoImpl extends AbstractBaseJdbc implements OrderSupplyDao {
	@Autowired
	private OrderSupplyMapper orderSupplyMapper;

	@Override
	public Long save(OrderSupply record) {
		record.setGmtCreate(new Date());
		record.setGmtModified(new Date());
		this.orderSupplyMapper.insertSelective(record);
		return getLastId();
	}

	@Override
	public int deleteById(Long id) {
		return this.orderSupplyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(OrderSupply record) {
		record.setGmtModified(new Date());
		return this.orderSupplyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public OrderSupply getById(Long id) {
		return this.orderSupplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<OrderSupply> listForPage(int pageCurrent, int pageSize, OrderSupplyExample example) {
		int count = this.orderSupplyMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<OrderSupply>(count, totalPage, pageCurrent, pageSize, this.orderSupplyMapper.selectByExample(example));
	}

	@Override
	public OrderSupply getBySupplySerialNo(Long supplySerialNo) {
		OrderSupplyExample example = new OrderSupplyExample();
		example.createCriteria().andSupplySerialNoEqualTo(supplySerialNo);
		List<OrderSupply> list = this.orderSupplyMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
}
