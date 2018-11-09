package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.ItemSupply;
import cn.mauth.issue.common.example.ItemSupplyExample;
import cn.mauth.issue.util.bjui.Page;

public interface ItemSupplyDao {
	int save(ItemSupply record);

	int deleteById(Long id);

	int updateById(ItemSupply record);

	ItemSupply getById(Long id);

	Page<ItemSupply> listForPage(int pageCurrent, int pageSize, ItemSupplyExample example);

	List<ItemSupply> listByItemId(Long itemId);
}
