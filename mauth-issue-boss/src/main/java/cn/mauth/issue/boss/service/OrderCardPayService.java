package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.OrderCardPayDao;
import cn.mauth.issue.common.entity.OrderCardPay;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCardPayService implements BaseService<OrderCardPay> {

    @Autowired
    private OrderCardPayDao dao;

    @Override
    public int save(OrderCardPay orderCardPay) {
        return dao.save(orderCardPay);
    }

    @Override
    public OrderCardPay getById(Long id) {
        return dao.getById(id);
    }

    @Override
    public int deleteById(Long id) {
        return dao.deleteById(id);
    }

    @Override
    public Page<OrderCardPay> listForPage(int pageCurrent, int pageSize, OrderCardPay orderCardPay) {
        return dao.page(new RequestPage<OrderCardPay>(pageCurrent,pageSize,orderCardPay," id desc "));
    }

    @Override
    public int updateById(OrderCardPay orderCardPay) {
        return dao.update(orderCardPay);
    }

    @Override
    public int updateAllById(OrderCardPay orderCardPay) {
        return dao.updateAll(orderCardPay);
    }
}
