package cn.mauth.issue.boss.utils;

import cn.mauth.issue.boss.bean.vo.SysMenuVO;
import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.util.Constants;
import cn.mauth.issue.util.JSONUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SessionUtils {

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    public static Session getSession(boolean var){
        return SecurityUtils.getSubject().getSession(var);
    }

    public static void setAttribute(Object key, Object value){
        SessionUtils.getSession().setAttribute(key,value);
    }

    public static void setAttribute(boolean var,Object key, Object value){
        SessionUtils.getSession(var).setAttribute(key,value);
    }

    public static Object getAttribute(Object key){
        return SessionUtils.getSession().getAttribute(key);
    }

    public static boolean isAdmin(){
        Object obj=SessionUtils.getAttribute(Constants.Session.ROLE);
        if(obj!=null && Constants.ADMIN.equals(obj.toString())){
            return true;
        }
        return false;
    }

    public static Long getUserInfoId(){
        return Long.valueOf(SessionUtils.getAttribute(Constants.Session.USER_ID).toString());
    }

    public static void setMenuAndRole(List<SysMenuVO> menuVOList){
        SessionUtils.setAttribute(false,Constants.Session.MENU, JSONUtil.toJSONString(menuVOList));
        Set<String> menuSet = new HashSet<>();
        SessionUtils.listMenu(menuSet, menuVOList);
        SessionUtils.setAttribute(Constants.Session.PERMISSIONS, JSONUtil.toJSONString(menuSet));
    }

    private static void listMenu(Set<String> menuSet, List<SysMenuVO> menuVOList) {
        if (CollectionUtil.isNotEmpty(menuVOList)) {
            for (SysMenuVO sm : menuVOList) {
                if (StringUtils.hasText(sm.getMenuUrl())) {
                    menuSet.add(sm.getMenuUrl());
                }
                listMenu(menuSet, sm.getList());
            }
        }
    }

    public static Set<String> getPermissions(){
        List<String> roles = JSONUtil.parseArray(SessionUtils.getAttribute(Constants.Session.PERMISSIONS).toString(), String.class);
        return new HashSet<>(roles);
    }

    public static SysUserInfo getCurrentUser(){
        return (SysUserInfo) SessionUtils.getAttribute(Constants.Session.USER);
    }

    public static void setAccect(String accect){
        SessionUtils.setAttribute(Constants.Session.ACCOUNT,accect);
    }

    public static String getAccount(){
        return SessionUtils.getAttribute(Constants.Session.ACCOUNT).toString();
    }

    public static boolean isUser(){
        return SessionUtils.getAttribute(Constants.Session.USER)!=null?true:false;
    }
}
