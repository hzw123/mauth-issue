package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.OrderTradePay;
import cn.mauth.issue.common.example.OrderTradePayExample;
import cn.mauth.issue.util.bjui.Page;

public interface OrderTradePayDao {
    Long save(OrderTradePay record);

    int deleteById(Long id);

    int updateById(OrderTradePay record);

    OrderTradePay getById(Long id);

    Page<OrderTradePay> listForPage(int pageCurrent, int pageSize, OrderTradePayExample example);
}
