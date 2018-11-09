package cn.mauth.issue.common.manager;

import cn.mauth.issue.common.entity.AcctInfo;
import cn.mauth.issue.common.entity.OrderTradePay;

public interface AcctInfoManager {

	/**
	 * 根据交易支付订单，账户金额变动进行事务操作
	 */
	AcctInfo commitBalance(OrderTradePay orderTradePay);
}
