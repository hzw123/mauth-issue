package cn.mauth.issue.boss.service;

import java.util.HashMap;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.OrderTradeQO;
import cn.mauth.issue.boss.bean.vo.OrderTradeVO;
import cn.mauth.issue.common.dao.OrderTradeDao;
import cn.mauth.issue.common.entity.OrderTrade;
import cn.mauth.issue.common.example.OrderTradeExample;
import cn.mauth.issue.common.example.OrderTradeExample.Criteria;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.Constants;
import cn.mauth.issue.util.HttpRestUtil;
import cn.mauth.issue.util.base.Result;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;
import cn.mauth.issue.util.enums.ItemCategoryEnum;
import cn.mauth.issue.util.enums.UserTypeEnum;
import com.xiaoleilu.hutool.util.ObjectUtil;

/**
 * 交易订单
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class OrderTradeService {

	@Autowired
	private OrderTradeDao dao;

	public Page<OrderTradeVO> listForPage(int pageCurrent, int pageSize, OrderTradeQO qo) {
		OrderTradeExample example = new OrderTradeExample();
		Criteria c = example.createCriteria();

		if (ObjectUtil.isNotNull(qo.getTradeNo())) {
			c.andTradeNoGreaterThanOrEqualTo(qo.getTradeNo());
		}

		if (StringUtils.isNotBlank(qo.getOrderNo())) {
			c.andOrderNoLike(PageUtil.likeRight(qo.getOrderNo()));
		}

		// 下游商户
		if (UserTypeEnum.MERCHANTS.getCode().equals(Integer.valueOf(SessionUtils.getAttribute(Constants.Session.USER_TYPE).toString()))) {
			c.andUserInfoIdEqualTo(Long.valueOf(SessionUtils.getAttribute(Constants.Session.USER_TYPE).toString()));
		}
		example.setOrderByClause(" id desc ");
		Page<OrderTrade> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, OrderTradeVO.class);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public OrderTradeVO getById(Long id) {
		OrderTradeVO vo = new OrderTradeVO();
		OrderTrade record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(OrderTradeQO qo) {
		OrderTrade record = new OrderTrade();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

	public Result<OrderTrade> repair(Long tradeNo, Integer itemCategory) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("tradeNo", tradeNo);
		if (itemCategory.equals(ItemCategoryEnum.EXCHANGE.getCode())) {
			// 兑换补单
			return HttpRestUtil.getForResultObject(ConfigUtil.REPAIR_ORDER_EXCHANGE_URL, map, OrderTrade.class);
		} else {
			// 充值补单
			return HttpRestUtil.getForResultObject(ConfigUtil.REPAIR_ORDER_RECHARGE_URL, map, OrderTrade.class);
		}
	}

	public Result<String> notify(Long tradeNo, Integer itemCategory) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("tradeNo", tradeNo);
		if (itemCategory.equals(ItemCategoryEnum.EXCHANGE.getCode())) {
			// 兑换补通知
			return HttpRestUtil.getForResultObject(ConfigUtil.REPAIR_NOTIFY_EXCHANGE_URL, map, String.class);
		} else {
			// 充值补通知
			return HttpRestUtil.getForResultObject(ConfigUtil.REPAIR_NOTIFY_RECHARGE_URL, map, String.class);
		}
	}

}
