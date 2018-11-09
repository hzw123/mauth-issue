package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.AcctLog;
import cn.mauth.issue.common.example.AcctLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AcctLogMapper {
    int countByExample(AcctLogExample example);

    int deleteByExample(AcctLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcctLog record);

    int insertSelective(AcctLog record);

    List<AcctLog> selectByExample(AcctLogExample example);

    AcctLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcctLog record, @Param("example") AcctLogExample example);

    int updateByExample(@Param("record") AcctLog record, @Param("example") AcctLogExample example);

    int updateByPrimaryKeySelective(AcctLog record);

    int updateByPrimaryKey(AcctLog record);
}
