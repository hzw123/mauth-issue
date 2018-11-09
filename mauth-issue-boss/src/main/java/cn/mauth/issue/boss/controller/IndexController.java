package cn.mauth.issue.boss.controller;

import java.util.List;

import cn.mauth.issue.boss.service.SysMenuService;
import cn.mauth.issue.boss.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.mauth.issue.boss.bean.vo.SysMenuVO;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.Constants;
import cn.mauth.issue.util.exception.BaseException;

@Controller
public class IndexController {

	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping("/index")
	public void index(ModelMap modelMap) {
		Long userInfoId = Long.valueOf(SessionUtils.getAttribute(Constants.Session.USER_ID).toString());
		List<SysMenuVO> menuVOList = sysMenuService.listMenuByUserInfoIdAndPlatformAppId(userInfoId, ConfigUtil.PLATFORM_APPID);
		if (menuVOList == null || menuVOList.isEmpty()) {
			throw new BaseException("没权限");
		}
		modelMap.put("menuList", menuVOList);
		SessionUtils.setMenuAndRole(menuVOList);
	}

	@RequestMapping("/context")
	public void context(ModelMap modelMap) {
		modelMap.put("javaVersion", System.getProperty("java.version"));
		modelMap.put("osName", System.getProperty("os.name"));
	}

}
