package cn.mauth.issue.boss.controller.admin;

import cn.mauth.issue.boss.service.SysPlatformService;
import cn.mauth.issue.boss.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mauth.issue.boss.bean.qo.SysRoleQO;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.enums.StatusIdEnum;

/**
 * 角色信息
 *
 * @author mauth
 * @since 2017-12-26
 */
@Controller
@RequestMapping(value = "/admin/sysRole")
public class SysRoleController extends BaseController {

	private final static String TARGETID = "admin-sysRole";

	@Autowired
	private SysRoleService service;

	@Autowired
	private SysPlatformService sysPlatformService;

	@RequestMapping(value = "/list")
	public void list(@RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @ModelAttribute SysRoleQO qo, ModelMap modelMap) {
		modelMap.put("page", service.listForPage(pageCurrent, pageSize, qo));
		modelMap.put("pageCurrent", pageCurrent);
		modelMap.put("pageSize", pageSize);
		modelMap.put("bean", qo);
		modelMap.put("sysPlatformList", sysPlatformService.listAll());
	}

	@RequestMapping(value = "/add")
	public void add(ModelMap modelMap) {
		modelMap.put("sysPlatformList", sysPlatformService.listAll());
	}

	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute SysRoleQO qo) {
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
	public String update(@ModelAttribute SysRoleQO qo) {
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
		modelMap.put("statusIdEnums", StatusIdEnum.values());
	}

}
