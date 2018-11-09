package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SupplyInfo;
import cn.mauth.issue.common.example.SupplyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SupplyInfoMapper {
    int countByExample(SupplyInfoExample example);

    int deleteByExample(SupplyInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplyInfo record);

    int insertSelective(SupplyInfo record);

    List<SupplyInfo> selectByExample(SupplyInfoExample example);

    SupplyInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplyInfo record, @Param("example") SupplyInfoExample example);

    int updateByExample(@Param("record") SupplyInfo record, @Param("example") SupplyInfoExample example);

    int updateByPrimaryKeySelective(SupplyInfo record);

    int updateByPrimaryKey(SupplyInfo record);
}
