package cn.mauth.issue.common.mapper;


import cn.mauth.issue.common.entity.Card;
import cn.mauth.issue.util.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardMapper extends BaseMapper<Card,Long> {

    /**
     * 上架
     * @return
     */
    List<Card> putAway();

}
