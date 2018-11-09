package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.MerchantInfo;
import cn.mauth.issue.common.example.MerchantInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantInfoMapper {
    int countByExample(MerchantInfoExample example);

    int deleteByExample(MerchantInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantInfo record);

    int insertSelective(MerchantInfo record);

    List<MerchantInfo> selectByExample(MerchantInfoExample example);

    MerchantInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantInfo record, @Param("example") MerchantInfoExample example);

    int updateByExample(@Param("record") MerchantInfo record, @Param("example") MerchantInfoExample example);

    int updateByPrimaryKeySelective(MerchantInfo record);

    int updateByPrimaryKey(MerchantInfo record);
}
