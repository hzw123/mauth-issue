package cn.mauth.issue.boss.service;

import java.util.List;

import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.common.dao.SysPlatformDao;
import cn.mauth.issue.common.entity.SysPlatform;
import cn.mauth.issue.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.mauth.issue.boss.bean.qo.SysRoleUserQO;
import cn.mauth.issue.boss.bean.vo.SysRoleUserVO;
import cn.mauth.issue.common.dao.SysRoleDao;
import cn.mauth.issue.common.dao.SysRoleUserDao;
import cn.mauth.issue.common.entity.SysRole;
import cn.mauth.issue.common.entity.SysRoleUser;
import cn.mauth.issue.util.ArrayListUtil;

/**
 * 角色用户关联表
 *
 * @author mauth
 * @since 2017-12-26
 */
@Component
public class SysRoleUserService {

	@Autowired
	private SysRoleUserDao dao;

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysPlatformDao sysPlatformDao;

	public int save(SysRoleUserQO qo, String ids) {
		if (StringUtils.hasText(ids)) {
			// 先删除旧的，再添加新的
			dao.deleteByUserInfoId(qo.getUserInfoId());
			// 拆分角色和平台拼接ID
			String[] roleIds = ids.split(",");
			for (String roleId : roleIds) {
				SysRoleUser sysRoleUser = new SysRoleUser();
				sysRoleUser.setRoleId(Long.parseLong(roleId));
				sysRoleUser.setPlatformId(getPlatformIdByRoleId(Long.parseLong(roleId)));
				sysRoleUser.setUserInfoId(qo.getUserInfoId());
				dao.save(sysRoleUser);
			}
		}
		return 1;
	}

	private Long getPlatformIdByRoleId(Long id) {
		SysRole bean = sysRoleDao.getById(id);
		return bean.getPlatformId();
	}

	public List<SysRoleUserVO> listByUserInfoId(Long userInfoId) {
		List<SysRoleUser> list = dao.listByUserInfoId(userInfoId);
		return ArrayListUtil.copy(list, SysRoleUserVO.class);
	}

	public void setAdmin(String platformAppid){
		Long userInfoId= Long.valueOf( SessionUtils.getAttribute(Constants.Session.USER_ID).toString());
		SysPlatform sysPlatform = sysPlatformDao.getByPlatformAppid(platformAppid);
		List<SysRoleUser> roleUserList = dao.listByUserInfoIdAndPlatformId(userInfoId, sysPlatform.getId());
		for (SysRoleUser sysRoleUser: roleUserList) {
			if(Constants.ADMIN.equals(sysRoleDao.getById(sysRoleUser.getRoleId()).getRoleName())){
				SessionUtils.setAttribute(false,Constants.Session.ROLE,Constants.ADMIN);
				break;
			}
		}
	}

}
