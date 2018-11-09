package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.ItemSupply;
import cn.mauth.issue.common.example.ItemSupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ItemSupplyMapper {
    int countByExample(ItemSupplyExample example);

    int deleteByExample(ItemSupplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemSupply record);

    int insertSelective(ItemSupply record);

    List<ItemSupply> selectByExample(ItemSupplyExample example);

    ItemSupply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemSupply record, @Param("example") ItemSupplyExample example);

    int updateByExample(@Param("record") ItemSupply record, @Param("example") ItemSupplyExample example);

    int updateByPrimaryKeySelective(ItemSupply record);

    int updateByPrimaryKey(ItemSupply record);
}
