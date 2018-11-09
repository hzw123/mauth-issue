package cn.mauth.issue.boss.controller.admin;

import java.util.List;

import cn.mauth.issue.boss.service.AreaInfoService;
import cn.mauth.issue.boss.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mauth.issue.boss.bean.qo.ItemQO;
import cn.mauth.issue.boss.bean.vo.AreaInfoVO;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.enums.CarrierTypeEnum;
import cn.mauth.issue.util.enums.FlowPackageTypeEnum;
import cn.mauth.issue.util.enums.FlowScopeEnum;
import cn.mauth.issue.util.enums.FlowStreamTypeEnum;
import cn.mauth.issue.util.enums.ItemCategoryEnum;
import cn.mauth.issue.util.enums.ItemStatusEnum;
import cn.mauth.issue.util.enums.ItemTypeEnum;

/**
 * 商品管理
 *
 * @author mauth
 * @since 2017-12-19
 */
@Controller
@RequestMapping(value = "/admin/item")
public class ItemController extends BaseController {

	private final static String TARGETID = "admin-item";

	@Autowired
	private ItemService service;
	@Autowired
	private AreaInfoService areaInfoService;
	
	@RequestMapping(value = "/list")
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute ItemQO qo, ModelMap modelMap) {
		modelMap.put("page", service.listForPage(pageCurrent, pageSize, qo));
		modelMap.put("pageCurrent", pageCurrent);
		modelMap.put("pageSize", pageSize);
		modelMap.put("bean", qo);
	}

	@RequestMapping(value = "/add")
	public void add() {

	}

	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute ItemQO qo) {
		if (service.save(qo) > 0) {
			return success(TARGETID);
		}
		return error("添加失败");
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
	public String update(@ModelAttribute ItemQO qo) {
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
		modelMap.put("carrierTypeEnums", CarrierTypeEnum.values());
		modelMap.put("itemTypeEnums", ItemTypeEnum.values());
		modelMap.put("itemStatusEnums", ItemStatusEnum.values());
		modelMap.put("flowScopeEnums", FlowScopeEnum.values());
		modelMap.put("flowPackageTypeEnums", FlowPackageTypeEnum.values());
		modelMap.put("flowStreamTypeEnums", FlowStreamTypeEnum.values());
		modelMap.put("itemCategoryEnums", ItemCategoryEnum.values());
	}

	@ModelAttribute("salesAreaList")
	public List<AreaInfoVO> salesAreaList() {
		return areaInfoService.listByProvince();
	}
}
