package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SysLogOpt;
import cn.mauth.issue.common.example.SysLogOptExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLogOptMapper {
    int countByExample(SysLogOptExample example);

    int deleteByExample(SysLogOptExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLogOpt record);

    int insertSelective(SysLogOpt record);

    List<SysLogOpt> selectByExample(SysLogOptExample example);

    SysLogOpt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLogOpt record, @Param("example") SysLogOptExample example);

    int updateByExample(@Param("record") SysLogOpt record, @Param("example") SysLogOptExample example);

    int updateByPrimaryKeySelective(SysLogOpt record);

    int updateByPrimaryKey(SysLogOpt record);
}
