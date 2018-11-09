package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.OrderCardPay;
import cn.mauth.issue.util.base.BaseMauth;

public interface OrderCardPayDao extends BaseMauth<OrderCardPay,Long> {

    OrderCardPay findByOrderCardId(Long orderCardId);
}
