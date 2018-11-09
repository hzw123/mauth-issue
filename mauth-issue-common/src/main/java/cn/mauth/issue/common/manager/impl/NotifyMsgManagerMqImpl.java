package cn.mauth.issue.common.manager.impl;

import java.util.TreeMap;

import cn.mauth.issue.util.base.BaseRoncoo;
import cn.mauth.issue.util.enums.ItemCategoryEnum;
import org.springframework.stereotype.Component;

import cn.mauth.issue.common.entity.OrderTrade;
import cn.mauth.issue.common.manager.NotifyMsgManager;

/**
 * mq消息处理
 */
@Component
public class NotifyMsgManagerMqImpl extends BaseRoncoo implements NotifyMsgManager {

	@Override
	public void notifyMsg(OrderTrade orderTrade) {
		TreeMap<String, Object> map = new TreeMap<>();
		map.put("tradeNo", orderTrade.getTradeNo());
		map.put("orderNo", orderTrade.getOrderNo());
		map.put("orderStatus", orderTrade.getOrderStatus());
		map.put("amont", orderTrade.getFacePrice());
		if (ItemCategoryEnum.EXCHANGE.getCode().equals(orderTrade.getItemCategory())) {
			// 兑换通知
			map.put("cardNo", orderTrade.getCardNo());
		} else if (ItemCategoryEnum.RECHARGE.getCode().equals(orderTrade.getItemCategory())) {
			// 充值通知
			map.put("mobile", orderTrade.getMobile());
		} else {
			logger.warn("未知商品类型={}", orderTrade.getItemCategory());
			return;
		}
		/*String result = HttpRestUtil.postForObject(orderTrade.getNotifyUrl(), map, String.class);
		logger.warn("通知下游：url={},参数={},返回={}", orderTrade.getNotifyUrl(), map, result);
		if (!"success".equalsIgnoreCase(result)) {
			// 失败，继续重复通知
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				logger.error("线程出错", e.getMessage());
			}
			result = HttpRestUtil.postForObject(orderTrade.getNotifyUrl(), map, String.class);
		}*/

	}

}
