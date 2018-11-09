package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.OrderTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mauth.issue.boss.bean.qo.OrderTradeQO;
import cn.mauth.issue.common.entity.OrderTrade;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.base.Result;
import cn.mauth.issue.util.enums.CarrierTypeEnum;
import cn.mauth.issue.util.enums.ChannelEnum;
import cn.mauth.issue.util.enums.FlowModeEnum;
import cn.mauth.issue.util.enums.FlowPackageTypeEnum;
import cn.mauth.issue.util.enums.FlowScopeEnum;
import cn.mauth.issue.util.enums.FlowStreamTypeEnum;
import cn.mauth.issue.util.enums.ItemCategoryEnum;
import cn.mauth.issue.util.enums.ItemTypeEnum;
import cn.mauth.issue.util.enums.OrderStatusEnum;
import cn.mauth.issue.util.enums.ResultEnum;

/**
 * 交易订单
 *
 * @author mauth
 * @since 2017-12-19
 */
@Controller
@RequestMapping(value = "/admin/orderTrade")
public class OrderTradeController extends BaseController {

	private final static String TARGETID = "admin-orderTrade";

	@Autowired
	private OrderTradeService service;

	/**
	 * 补通知功能
	 */
	@ResponseBody
	@RequestMapping(value = "/notify")
	public String notify(@RequestParam(value = "tradeNo") Long tradeNo, @RequestParam(value = "itemCategory") Integer itemCategory) {
		Result<String> resultOrderTrade = service.notify(tradeNo, itemCategory);
		if (!resultOrderTrade.getCode().equals(ResultEnum.SUCCESS.getCode())) {
			return error(resultOrderTrade.getMsg());
		}
		return ties(TARGETID, "补通知成功");
	}
	/**
	 * 补单功能
	 */
	@ResponseBody
	@RequestMapping(value = "/repair")
	public String repair(@RequestParam(value = "tradeNo") Long tradeNo, @RequestParam(value = "itemCategory") Integer itemCategory) {
		Result<OrderTrade> resultOrderTrade = service.repair(tradeNo, itemCategory);
		if (!resultOrderTrade.getCode().equals(ResultEnum.SUCCESS.getCode())) {
			return error(resultOrderTrade.getMsg());
		}
		return ties(TARGETID, "补单成功");
	}

	@RequestMapping(value = "/list")
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute OrderTradeQO qo, ModelMap modelMap) {
		modelMap.put("page", service.listForPage(pageCurrent, pageSize, qo));
		modelMap.put("pageCurrent", pageCurrent);
		modelMap.put("pageSize", pageSize);
		modelMap.put("bean", qo);
	}

	@RequestMapping(value = "/add")
	public void add() {

	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "id") Long id) {
		if (service.deleteById(id) > 0) {
			return delete(TARGETID);
		}
		return error("删除失败");
	}

	@RequestMapping(value = "/edit")
	public void edit(@RequestParam(value = "id") Long id, ModelMap modelMap) {
		modelMap.put("bean", service.getById(id));
	}

	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(@ModelAttribute OrderTradeQO qo) {
		if (service.updateById(qo) > 0) {
			return success(TARGETID);
		}
		return error("修改失败");
	}

	@RequestMapping(value = "/view")
	public void view(@RequestParam(value = "id") Long id, ModelMap modelMap) {
		modelMap.put("bean", service.getById(id));
	}

	@ModelAttribute
	public void enums(ModelMap modelMap) {
		modelMap.put("orderStatusEnums", OrderStatusEnum.values());
		modelMap.put("channelEnums", ChannelEnum.values());
		modelMap.put("carrierTypeEnums", CarrierTypeEnum.values());
		modelMap.put("itemTypeEnums", ItemTypeEnum.values());
		modelMap.put("itemCategoryEnums", ItemCategoryEnum.values());
		modelMap.put("flowScopeEnums", FlowScopeEnum.values());
		modelMap.put("flowModeEnums", FlowModeEnum.values());
		modelMap.put("flowPackageTypeEnums", FlowPackageTypeEnum.values());
		modelMap.put("flowStreamTypeEnums", FlowStreamTypeEnum.values());
	}

}
