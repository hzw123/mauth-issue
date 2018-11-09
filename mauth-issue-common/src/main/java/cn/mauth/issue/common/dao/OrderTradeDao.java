package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.OrderTrade;
import cn.mauth.issue.common.example.OrderTradeExample;
import cn.mauth.issue.util.bjui.Page;

public interface OrderTradeDao {
	Long save(OrderTrade record);

	int deleteById(Long id);

	int updateById(OrderTrade record);

	OrderTrade getById(Long id);

	Page<OrderTrade> listForPage(int pageCurrent, int pageSize, OrderTradeExample example);

	OrderTrade getByOrderNoAndUserInfoId(String orderNo, Long userInfoId);

	OrderTrade getByTradeNo(Long tradeNo);
}
