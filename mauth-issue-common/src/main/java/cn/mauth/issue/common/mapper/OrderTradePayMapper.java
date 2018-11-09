package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.OrderTradePay;
import cn.mauth.issue.common.example.OrderTradePayExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderTradePayMapper {
    int countByExample(OrderTradePayExample example);

    int deleteByExample(OrderTradePayExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTradePay record);

    int insertSelective(OrderTradePay record);

    List<OrderTradePay> selectByExample(OrderTradePayExample example);

    OrderTradePay selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTradePay record, @Param("example") OrderTradePayExample example);

    int updateByExample(@Param("record") OrderTradePay record, @Param("example") OrderTradePayExample example);

    int updateByPrimaryKeySelective(OrderTradePay record);

    int updateByPrimaryKey(OrderTradePay record);
}
