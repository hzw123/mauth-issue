package cn.mauth.issue.common.manager;

import cn.mauth.issue.common.entity.CardInfo;
import cn.mauth.issue.common.entity.CashFlow;

import java.util.Map;

/** 储值卡兑换接口*/
public interface CardInfoExchange {

    /**
     * 获得储值卡信息
     * @param uuid
     * @return
     */
    CardInfo  query(String uuid,String authSign);

    /**
     * 兑换
     * @param cardKey 卡密
     * @param authSign 身份标识
     * @param orderNo 兑换订单号
     * @param mac
     * @return
     */
    Map<String,String> exchange(String cardKey, String authSign, String orderNo,String mac);


    /**
     * 查询兑换结果
     * @param cashFlow
     * @return
     */
    CashFlow find(CashFlow cashFlow);

}
