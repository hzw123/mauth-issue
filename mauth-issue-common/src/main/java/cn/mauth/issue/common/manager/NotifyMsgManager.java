package cn.mauth.issue.common.manager;

import cn.mauth.issue.common.entity.OrderTrade;

public interface NotifyMsgManager {

	/**
	 * 消息通知
	 */
	void notifyMsg(OrderTrade orderTrade);
}
