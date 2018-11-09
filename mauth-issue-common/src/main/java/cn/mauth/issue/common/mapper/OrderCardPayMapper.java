package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.OrderCardPay;
import cn.mauth.issue.util.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderCardPayMapper extends BaseMapper<OrderCardPay,Long>{

    OrderCardPay findByOrderCardId(Long orderCardId);
}
