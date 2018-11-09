package cn.mauth.issue.common.manager;

import cn.mauth.issue.common.entity.OrderCard;
import cn.mauth.issue.util.ZipData;

import java.util.List;

public interface OrderCardManager {

    /**
     * 订单完成支付
     * @param orderId
     * @return
     */
    String pay(Long orderId);

    /**
     *压缩加密
     * @param orderId
     * @return
     */
    String createExcel(Long orderId,String loadPassword);

    String createExcel(List<Long> ids);

    ZipData createExcelData(Long orderId);

    /**
     * 激活储蓄卡
     * @param id
     * @return
     */
    int activateCardInfo(Long id);


    /**
     * 保存储值卡订单
     * @param orderCard
     * @param orderCard
     * @return
     */
    int save(OrderCard orderCard);

    OrderCard view(Long id);

}
