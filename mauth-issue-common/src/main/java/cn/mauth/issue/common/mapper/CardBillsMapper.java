package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.CardBills;
import cn.mauth.issue.util.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardBillsMapper extends BaseMapper<CardBills,Long>{

    List<CardBills> findByOrderCardId(Long orderCardId);

    int deleteByOrderCardId(Long orderCardId);
}
