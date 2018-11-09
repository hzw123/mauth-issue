package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.util.RequestPage;
import cn.mauth.issue.util.base.BaseMauth;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.StatisticalQuery;
import cn.mauth.issue.util.bjui.StatisticsInfo;

public interface OrderCardDao extends BaseMauth<OrderCard,Long>{

    OrderCard findByOrderNo(Long orderNo);

    int updateLoadPassword(Long id,String loadPassword);

    String findLoadPassword(Long id);

    Page<StatisticsInfo> selectStatist(RequestPage<StatisticalQuery> requestPage);

    StatisticsInfo findTotalStatistion(StatisticalQuery query);

    StatisticsInfo findCashStatistion(StatisticalQuery query);
}
