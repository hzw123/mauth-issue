package cn.mauth.issue.common.dao;

import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.util.base.BaseMauth;
import cn.mauth.issue.util.bjui.StatisticsInfo;

import java.util.List;

public interface CardInfoDao extends BaseMauth<CardInfo,Long> {

    CardInfo findByUUID(String uuid);


    List<CardInfo> getOrderId(Long orderId);

    List<CardInfo> findByOrderIds(List<Long> ids);

    List<CardInfo> findByOrderCardPayId(Long payId);

    int activeStatus(Long id);

    List<StatisticsInfo> getCashFace(List<Long> nos);

    CardInfo findByUUIDAndAuthSign(String cardKey,String authSign);
}