package cn.mauth.issue.common.dao.impl;

import java.util.Date;
import java.util.List;

import cn.mauth.issue.common.entity.ItemSupply;
import cn.mauth.issue.common.example.ItemSupplyExample;
import cn.mauth.issue.common.mapper.ItemSupplyMapper;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.mauth.issue.common.dao.ItemSupplyDao;

@Repository
public class ItemSupplyDaoImpl implements ItemSupplyDao {
    @Autowired
    private ItemSupplyMapper itemSupplyMapper;

    @Override
	public int save(ItemSupply record) {
    	record.setGmtCreate(new Date());
    	record.setGmtModified(new Date());
        return this.itemSupplyMapper.insertSelective(record);
    }

    @Override
	public int deleteById(Long id) {
        return this.itemSupplyMapper.deleteByPrimaryKey(id);
    }

    @Override
	public int updateById(ItemSupply record) {
    	record.setGmtModified(new Date());
        return this.itemSupplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
	public ItemSupply getById(Long id) {
        return this.itemSupplyMapper.selectByPrimaryKey(id);
    }

    @Override
	public Page<ItemSupply> listForPage(int pageCurrent, int pageSize, ItemSupplyExample example) {
        int count = this.itemSupplyMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<ItemSupply>(count, totalPage, pageCurrent, pageSize, this.itemSupplyMapper.selectByExample(example));
    }

	@Override
	public List<ItemSupply> listByItemId(Long itemId) {
		ItemSupplyExample example = new ItemSupplyExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		example.setOrderByClause(" priority asc, cost_price asc, id desc ");
		return this.itemSupplyMapper.selectByExample(example);
	}
}
