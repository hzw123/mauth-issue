package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseMapper;
import cn.mauth.issue.util.bjui.StatisticalQuery;
import cn.mauth.issue.util.bjui.StatisticsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderCardMapper extends BaseMapper<OrderCard,Long> {

    OrderCard findByOrderNo(Long orderNo);

    int updateLoadPassword(@Param("id") Long id,@Param("loadPassword") String loadPassword);

    String findLoadPassword(Long id);

    List<StatisticsInfo> selectStatist(RequestPage<StatisticalQuery> requestPage);

    int statistCount(StatisticalQuery query);

    StatisticsInfo findTotalStatistion(StatisticalQuery query);

    StatisticsInfo findCashStatistion(StatisticalQuery query);
}
