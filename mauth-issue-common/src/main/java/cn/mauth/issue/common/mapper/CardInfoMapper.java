package cn.mauth.issue.common.mapper;

import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.util.base.BaseMapper;
import cn.mauth.issue.util.bjui.CardType;
import cn.mauth.issue.util.bjui.StatisticsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardInfoMapper extends BaseMapper<CardInfo,Long> {
    List<CardInfo> findByOrderCardId(Long orderId);

    List<CardInfo> findByOrderCardIds(List<Long> ids);

    CardInfo findByUUID(String uuid);

    List<CardInfo> findByOrderCardPayId(Long payId);

    int activeStatus(Long id);

    /**
     *已经兑换出去的卡总面值
     * @return
     */
    int findCashOutFaceValue();

    /**
     * 尚未兑换的总面值
     * @return
     */
    int findUnCashOutFaceValue();

    /**
     * 不同的面额数量
     */
    CardType findCardType();

    List<StatisticsInfo> getCashOut(List<Long> nos);

    CardInfo findByUUIDAndAuthSign(@Param("cardKey") String cardKey,@Param("authSign") String authSign);
}
