package cn.mauth.issue.boss.controller.admin;

import java.util.List;

import cn.mauth.issue.boss.service.SysPlatformService;
import cn.mauth.issue.boss.service.SysRoleService;
import cn.mauth.issue.boss.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mauth.issue.boss.bean.qo.SysRoleUserQO;
import cn.mauth.issue.boss.bean.vo.SysRoleUserVO;
import cn.mauth.issue.util.base.BaseController;
import cn.mauth.issue.util.enums.StatusIdEnum;

/**
 * 角色用户关联表
 *
 * @author mauth
 * @since 2017-12-26
 */
@Controller
@RequestMapping(value = "/admin/sysRoleUser")
public class SysRoleUserController extends BaseController {

	private final static String TARGETID = "admin-sysRoleUser";

	@Autowired
	private SysRoleUserService service;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysPlatformService sysPlatformService;

	@RequestMapping(value = "/set")
	public void set(@ModelAttribute SysRoleUserQO qo, ModelMap modelMap) {
		List<SysRoleUserVO> list = service.listByUserInfoId(qo.getUserInfoId());
		modelMap.put("roleUserList", list);
		modelMap.put("roleList", sysRoleService.listRoleForUserInfo(qo, list, qo.getUserInfoId()));
		modelMap.put("bean", qo);
		modelMap.put("sysPlatformList", sysPlatformService.listAll());
	}

	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute SysRoleUserQO qo, @RequestParam(value = "ids") String ids) {
		if (service.save(qo, ids) > 0) {
			return success(TARGETID);
		}
		return error("添加失败");
	}
	
	@ModelAttribute
	public void enums(ModelMap modelMap) {
		modelMap.put("statusIdEnums", StatusIdEnum.values());
	}

}
