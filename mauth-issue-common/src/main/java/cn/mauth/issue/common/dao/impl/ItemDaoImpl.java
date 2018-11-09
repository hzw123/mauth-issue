package cn.mauth.issue.common.dao.impl;

import java.util.Date;
import java.util.List;

import cn.mauth.issue.common.entity.Item;
import cn.mauth.issue.common.example.ItemExample;
import cn.mauth.issue.common.mapper.ItemMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.ItemDao;

@Repository
public class ItemDaoImpl implements ItemDao {
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public int save(Item record) {
		record.setGmtCreate(new Date());
		record.setGmtModified(new Date());
		return this.itemMapper.insertSelective(record);
	}

	@Override
	public int deleteById(Long id) {
		return this.itemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(Item record) {
		record.setGmtModified(new Date());
		return this.itemMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Item getById(Long id) {
		return this.itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<Item> listForPage(int pageCurrent, int pageSize, ItemExample example) {
		int count = this.itemMapper.countByExample(example);
		pageSize = PageUtil.checkPageSize(pageSize);
		pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = PageUtil.countTotalPage(count, pageSize);
		example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		return new Page<Item>(count, totalPage, pageCurrent, pageSize, this.itemMapper.selectByExample(example));
	}

	@Override
	public List<Item> listByItemCategoryAndItemTypeAndFacePrice(Integer ItemCategory, Integer itemType, String facePrice) {
		ItemExample example = new ItemExample();
		ItemExample.Criteria c = example.createCriteria();
		c.andItemCategoryEqualTo(ItemCategory);
		c.andItemTypeEqualTo(itemType);
		c.andFacePriceEqualTo(facePrice);
		return this.itemMapper.selectByExample(example);
	}

	@Override
	public Item getByItemNo(String itemNo) {
		ItemExample example = new ItemExample();
		ItemExample.Criteria c = example.createCriteria();
		c.andItemNoEqualTo(itemNo);
		List<Item> list = this.itemMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Item> listByItemCategoryAndItemTypeAndProvinceCodeAndCarrierTypeAndFacePrice(Integer ItemCategory, Integer itemType, String provinceCode, Integer carrierType, String facePrice) {
		ItemExample example = new ItemExample();
		ItemExample.Criteria c = example.createCriteria();
		c.andItemCategoryEqualTo(ItemCategory);
		c.andItemTypeEqualTo(itemType);
		c.andSalesAreaEqualTo(provinceCode);
		c.andCarrierTypeEqualTo(carrierType);
		c.andFacePriceEqualTo(facePrice);
		return this.itemMapper.selectByExample(example);
	}

}
