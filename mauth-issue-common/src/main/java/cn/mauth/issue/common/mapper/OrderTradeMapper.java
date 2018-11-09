package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.OrderTrade;
import cn.mauth.issue.common.example.OrderTradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderTradeMapper {
    int countByExample(OrderTradeExample example);

    int deleteByExample(OrderTradeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTrade record);

    int insertSelective(OrderTrade record);

    List<OrderTrade> selectByExample(OrderTradeExample example);

    OrderTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTrade record, @Param("example") OrderTradeExample example);

    int updateByExample(@Param("record") OrderTrade record, @Param("example") OrderTradeExample example);

    int updateByPrimaryKeySelective(OrderTrade record);

    int updateByPrimaryKey(OrderTrade record);
}
