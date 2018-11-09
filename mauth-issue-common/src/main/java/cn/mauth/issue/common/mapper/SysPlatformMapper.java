package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SysPlatform;
import cn.mauth.issue.common.example.SysPlatformExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysPlatformMapper {
    int countByExample(SysPlatformExample example);

    int deleteByExample(SysPlatformExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysPlatform record);

    int insertSelective(SysPlatform record);

    List<SysPlatform> selectByExample(SysPlatformExample example);

    SysPlatform selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysPlatform record, @Param("example") SysPlatformExample example);

    int updateByExample(@Param("record") SysPlatform record, @Param("example") SysPlatformExample example);

    int updateByPrimaryKeySelective(SysPlatform record);

    int updateByPrimaryKey(SysPlatform record);
}
