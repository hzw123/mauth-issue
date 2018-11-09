package cn.mauth.issue.common.dao;

import java.util.List;

import cn.mauth.issue.common.entity.Item;
import cn.mauth.issue.common.example.ItemExample;
import cn.mauth.issue.util.bjui.Page;

public interface ItemDao {
	int save(Item record);

	int deleteById(Long id);

	int updateById(Item record);

	Item getById(Long id);

	Page<Item> listForPage(int pageCurrent, int pageSize, ItemExample example);

	Item getByItemNo(String itemNo);

	List<Item> listByItemCategoryAndItemTypeAndFacePrice(Integer ItemCategory, Integer itemType, String facePrice);

	List<Item> listByItemCategoryAndItemTypeAndProvinceCodeAndCarrierTypeAndFacePrice(Integer ItemCategory, Integer itemType, String provinceCode, Integer carrierType, String facePrice);

}
