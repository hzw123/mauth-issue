package cn.mauth.issue.boss.service;

import cn.mauth.issue.common.dao.OrderCardDao;
import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseService;
import cn.mauth.issue.util.bjui.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderCardService implements BaseService<OrderCard> {

    @Autowired
    private OrderCardDao orderCardDao;

    @Override
    public int save(OrderCard orderCard) {
        return orderCardDao.save(orderCard);
    }

    @Override
    public int deleteById(Long id) {
        return orderCardDao.deleteById(id);
    }

    @Override
    public OrderCard getById(Long id) {
        return orderCardDao.getById(id);
    }

    @Override
    public Page<OrderCard> listForPage(int pageCurrent, int pageSize, OrderCard orderCard) {
        if(StringUtils.isEmpty(orderCard.getOrderType()))
            orderCard.setOrderType(null);
        return orderCardDao.page(new RequestPage<>(pageCurrent,pageSize,orderCard," id desc "));
    }

    @Override
    public int updateById(OrderCard orderCard) {
        orderCard.setGmtModified(new Date());
        return this.orderCardDao.update(orderCard);
    }

    @Override
    public int updateAllById(OrderCard orderCard) {
        orderCard.setGmtModified(new Date());
        return this.orderCardDao.update(orderCard);
    }

    public String getPwd(Long id){
        return orderCardDao.findLoadPassword(id);
    }

}
