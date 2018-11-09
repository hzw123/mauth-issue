package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.common.example.SysUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserInfoMapper {
    int countByExample(SysUserInfoExample example);

    int deleteByExample(SysUserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    List<SysUserInfo> selectByExample(SysUserInfoExample example);

    SysUserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserInfo record, @Param("example") SysUserInfoExample example);

    int updateByExample(@Param("record") SysUserInfo record, @Param("example") SysUserInfoExample example);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    SysUserInfo findByUsername(String username);
}
