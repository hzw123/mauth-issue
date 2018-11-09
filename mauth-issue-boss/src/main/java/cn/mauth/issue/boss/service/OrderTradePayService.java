package cn.mauth.issue.boss.service;

import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.mauth.issue.boss.bean.qo.OrderTradePayQO;
import cn.mauth.issue.boss.bean.vo.OrderTradePayVO;
import cn.mauth.issue.common.dao.OrderTradePayDao;
import cn.mauth.issue.common.entity.OrderTradePay;
import cn.mauth.issue.common.example.OrderTradePayExample;
import cn.mauth.issue.common.example.OrderTradePayExample.Criteria;
import cn.mauth.issue.util.bjui.Page;
import cn.mauth.issue.util.bjui.PageUtil;

/**
 * 支付订单
 *
 * @author mauth
 * @since 2017-12-19
 */
@Component
public class OrderTradePayService {

	@Autowired
	private OrderTradePayDao dao;

	public Page<OrderTradePayVO> listForPage(int pageCurrent, int pageSize, OrderTradePayQO qo) {
		OrderTradePayExample example = new OrderTradePayExample();
		Criteria c = example.createCriteria();

		/** 判断是否是管理员*/
		if(!SessionUtils.isAdmin()){
			c.andUserInfoIdEqualTo(SessionUtils.getUserInfoId());
		}

		example.setOrderByClause(" id desc ");
		Page<OrderTradePay> page = dao.listForPage(pageCurrent, pageSize, example);
		return PageUtil.transform(page, OrderTradePayVO.class);
	}

	public int deleteById(Long id) {
		return dao.deleteById(id);
	}

	public OrderTradePayVO getById(Long id) {
		OrderTradePayVO vo = new OrderTradePayVO();
		OrderTradePay record = dao.getById(id);
		BeanUtils.copyProperties(record, vo);
		return vo;
	}

	public int updateById(OrderTradePayQO qo) {
		OrderTradePay record = new OrderTradePay();
		BeanUtils.copyProperties(qo, record);
		return dao.updateById(record);
	}

}
