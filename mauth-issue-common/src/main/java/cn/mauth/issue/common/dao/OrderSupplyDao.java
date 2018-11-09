package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.OrderSupply;
import cn.mauth.issue.common.example.OrderSupplyExample;
import cn.mauth.issue.util.bjui.Page;

public interface OrderSupplyDao {
	Long save(OrderSupply record);

    int deleteById(Long id);

    int updateById(OrderSupply record);

    OrderSupply getById(Long id);

    Page<OrderSupply> listForPage(int pageCurrent, int pageSize, OrderSupplyExample example);

	OrderSupply getBySupplySerialNo(Long supplySerialNo);
}
