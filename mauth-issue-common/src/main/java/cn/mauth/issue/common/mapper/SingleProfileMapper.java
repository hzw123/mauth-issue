package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.SingleProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SingleProfileMapper {

    SingleProfile getSingleeProfileByName(@Param("name") String name);

    int update(SingleProfile singleProfile);
}
