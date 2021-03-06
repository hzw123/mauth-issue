package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SysMenuRole;
import cn.mauth.issue.common.example.SysMenuRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysMenuRoleMapper {
    int countByExample(SysMenuRoleExample example);

    int deleteByExample(SysMenuRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMenuRole record);

    int insertSelective(SysMenuRole record);

    List<SysMenuRole> selectByExample(SysMenuRoleExample example);

    SysMenuRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysMenuRole record, @Param("example") SysMenuRoleExample example);

    int updateByExample(@Param("record") SysMenuRole record, @Param("example") SysMenuRoleExample example);

    int updateByPrimaryKeySelective(SysMenuRole record);

    int updateByPrimaryKey(SysMenuRole record);

    List<SysMenuRole> findByRoleId(Long roleId);
}
