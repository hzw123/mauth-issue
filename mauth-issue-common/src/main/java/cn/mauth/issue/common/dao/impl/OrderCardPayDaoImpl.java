package cn.mauth.issue.common.dao.impl;

import cn.mauth.issue.common.dao.OrderCardPayDao;
import cn.mauth.issue.common.entity.OrderCardPay;
import cn.mauth.issue.common.mapper.OrderCardPayMapper;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.AbstractBaseJdbc;
import cn.mauth.issue.util.bjui.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCardPayDaoImpl extends AbstractBaseJdbc implements OrderCardPayDao {

    @Autowired
    private OrderCardPayMapper mapper;

    @Override
    public int save(OrderCardPay orderCardPay) {
        return mapper.insert(orderCardPay);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int update(OrderCardPay orderCardPay) {
        return mapper.update(orderCardPay);
    }

    @Override
    public OrderCardPay getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public Page<OrderCardPay> page(RequestPage<OrderCardPay> requestPage) {
        return page(requestPage,mapper);
    }

    @Override
    public int updateAll(OrderCardPay orderCardPay) {
        return mapper.updateAll(orderCardPay);
    }

    @Override
    public OrderCardPay findByOrderCardId(Long orderCardId) {
        return mapper.findByOrderCardId(orderCardId);
    }
}
