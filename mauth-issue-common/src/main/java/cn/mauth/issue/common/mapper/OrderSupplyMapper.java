package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.OrderSupply;
import cn.mauth.issue.common.example.OrderSupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderSupplyMapper {
    int countByExample(OrderSupplyExample example);

    int deleteByExample(OrderSupplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSupply record);

    int insertSelective(OrderSupply record);

    List<OrderSupply> selectByExample(OrderSupplyExample example);

    OrderSupply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderSupply record, @Param("example") OrderSupplyExample example);

    int updateByExample(@Param("record") OrderSupply record, @Param("example") OrderSupplyExample example);

    int updateByPrimaryKeySelective(OrderSupply record);

    int updateByPrimaryKey(OrderSupply record);
}
