package cn.mauth.issue.common.manager;

import cn.mauth.issue.common.entity.CardInfo;

/**
 * 储值卡激活接口
 */
public interface CardInfoManager {

    CardInfo queryCardInfo(String cardKey, String authSign);

    int exchange(CardInfo cardInfo);
}
