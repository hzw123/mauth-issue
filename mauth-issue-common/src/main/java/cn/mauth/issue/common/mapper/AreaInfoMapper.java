package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.AreaInfo;
import cn.mauth.issue.common.example.AreaInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AreaInfoMapper {
    int countByExample(AreaInfoExample example);

    int deleteByExample(AreaInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AreaInfo record);

    int insertSelective(AreaInfo record);

    List<AreaInfo> selectByExample(AreaInfoExample example);

    AreaInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AreaInfo record, @Param("example") AreaInfoExample example);

    int updateByExample(@Param("record") AreaInfo record, @Param("example") AreaInfoExample example);

    int updateByPrimaryKeySelective(AreaInfo record);

    int updateByPrimaryKey(AreaInfo record);
}
