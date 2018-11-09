package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.common.example.SysLogLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysLogLoginMapper {
    int countByExample(SysLogLoginExample example);

    int deleteByExample(SysLogLoginExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysLogLogin record);

    int insertSelective(SysLogLogin record);

    List<SysLogLogin> selectByExample(SysLogLoginExample example);

    SysLogLogin selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysLogLogin record, @Param("example") SysLogLoginExample example);

    int updateByExample(@Param("record") SysLogLogin record, @Param("example") SysLogLoginExample example);

    int updateByPrimaryKeySelective(SysLogLogin record);

    int updateByPrimaryKey(SysLogLogin record);

    SysLogLogin getLastSysLogLogin(@Param("userId") Long userId);

    SysLogLogin getLastSysLogLoginOfSingleName(@Param("singleName") String singleName);

    List<SysLogLogin> findAll();

}
