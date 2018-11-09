package cn.mauth.issue.boss.common;

import cn.mauth.issue.boss.saml.Saml2Token;
import cn.mauth.issue.boss.saml.exception.Saml2TokenValidationException;
import cn.mauth.issue.boss.service.SysRoleUserService;
import cn.mauth.issue.boss.utils.HttpUtils;
import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.common.dao.SysLogLoginDao;
import cn.mauth.issue.common.dao.SysRoleDao;
import cn.mauth.issue.common.dao.SysRoleUserDao;
import cn.mauth.issue.common.dao.SysUserInfoDao;
import cn.mauth.issue.common.entity.SysLogLogin;
import cn.mauth.issue.common.entity.SysRole;
import cn.mauth.issue.common.entity.SysRoleUser;
import cn.mauth.issue.common.entity.SysUserInfo;
import cn.mauth.issue.util.ConfigUtil;
import cn.mauth.issue.util.Constants;
import cn.mauth.issue.util.JSONUtil;
import cn.mauth.issue.util.enums.StatusIdEnum;
import cn.mauth.issue.util.enums.UserTypeEnum;
import com.roncoo.spring.boot.autoconfigure.shiro.ShiroRealm;
import com.xiaoleilu.hutool.crypto.DigestUtil;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.http.HttpUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Component("shiroRealm")
public class MyShiroRealm extends ShiroRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Autowired
    private SysUserInfoDao sysUserInfoDao;
    @Autowired
    private SysLogLoginDao sysLogLoginDao;
    @Autowired
    private SysRoleUserDao sysRoleUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleUserService service;

    /**
     * 授权认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------------执行Shiro权限认证---------------------");
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            doClearCache(principals);
            SecurityUtils.getSubject().logout();
            return null;
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(SessionUtils.getPermissions());
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        if(arg0 instanceof Saml2Token){
            return single((Saml2Token) arg0);
        }
        UsernamePasswordToken token = (UsernamePasswordToken) arg0;
        String name=token.getUsername();
        String pwd=new String(token.getPassword());
        logger.info("验证当前Subject时获取到token为：[\n\tusername=" +name+",\n\tpassword="+pwd+",\n\thost=" +token.getHost()+",\n\trememberMe=" +token.isRememberMe()+"\n]");
        if(StringUtils.isEmpty(name)){
            throw new UnknownAccountException("没有用户！");
        }

        SysUserInfo sysUserInfo = sysUserInfoDao.getByLoginName(name);
        if (null == sysUserInfo) {
            throw new UnknownAccountException("账号不存在");
        }

        if (!sysUserInfo.getPwd().equals(DigestUtil.md5Hex(sysUserInfo.getSalt() + pwd))) {
            throw new UnknownAccountException("账号或者密码不正确");
        }

        if(sysUserInfo.getStatusId()==2){
            throw new LockedAccountException("账户已冻结");
        }

        if(sysUserInfo.getStatusId()==3){
            throw new AuthenticationException("账户已注销");
        }

        MyShiroRealm.addLoginLog(sysUserInfo,sysLogLoginDao,service,false);

        return new SimpleAuthenticationInfo(name, pwd, getName());
    }


    private AuthenticationInfo single(Saml2Token saml2Token){
        if (saml2Token == null) {
            throw new Saml2TokenValidationException("AuthenticationToken not bull");
        }

        String nameId=saml2Token.getUsername();
        String samlToken=new String(saml2Token.getPassword());

        PrincipalCollection principalCollection = new SimplePrincipalCollection(nameId, getName());

        HttpUtils.login(nameId);

        SysUserInfo sysUserInfo=sysUserInfoDao.getByLoginName(nameId);

        if(sysUserInfo==null){
            sysUserInfo=new SysUserInfo();
            Map<String,String> data=saml2Token.getData();
            if(data!=null){
                Date time=new Date();
                sysUserInfo.setGmtCreate(time);
                sysUserInfo.setGmtModified(time);
                sysUserInfo.setLoginName(nameId);
                sysUserInfo.setLoginName(nameId);
                sysUserInfo.setEmail(data.get("email"));
                sysUserInfo.setStatusId(StatusIdEnum.NORMAL.getCode());
                sysUserInfo.setSalt(SecureUtil.simpleUUID());
                sysUserInfo.setPwd(DigestUtil.md5Hex(sysUserInfo.getSalt() + "issue123456"));
                sysUserInfo.setUserType(UserTypeEnum.USER.getCode());
                sysUserInfoDao.save(sysUserInfo);
                sysUserInfo=sysUserInfoDao.getByLoginName(nameId);
                SysRole role=sysRoleDao.getById(3L);
                SysRoleUser sysRoleUser=new SysRoleUser();
                sysRoleUser.setGmtCreate(time);
                sysRoleUser.setPlatformId(role.getPlatformId());
                sysRoleUser.setRoleId(role.getId());
                sysRoleUser.setUserInfoId(sysUserInfo.getId());
                sysRoleUser.setStatusId(1);
                sysRoleUserDao.save(sysRoleUser);
            }
        }

        MyShiroRealm.addLoginLog(sysUserInfo,sysLogLoginDao,service,true);

        return new SimpleAuthenticationInfo(principalCollection, samlToken);

    }

    public static void addLoginLog(SysUserInfo sysUserInfo,SysLogLoginDao sysLogLoginDao,SysRoleUserService service,boolean falg){

        SysLogLogin logLogin=new SysLogLogin();

        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String lastId="";
        String ip= HttpUtil.getClientIP(request);
        Date lastTime=new Date();

        if(falg){
            String account=HttpUtils.getAccount();
            logLogin.setSingleName(account);
        }

        SysLogLogin last=sysLogLoginDao.getLastSysLogLogin(sysUserInfo.getId());

        if(last!=null){
            lastId=last.getLoginIp();
            lastTime=last.getGmtCreate();
        }
        logLogin.setGmtCreate(new Date());
        logLogin.setUserInfoId(sysUserInfo.getId());
        logLogin.setLastLoginIp(lastId==""?ip:lastId);
        logLogin.setLastLoginTime(lastTime);
        logLogin.setLoginName(sysUserInfo.getLoginName());
        logLogin.setLoginIp(ip);

        if(sysLogLoginDao.save(logLogin)>0){
            logger.info(sysUserInfo.getNickName()+"登陆成功！");
        }
        SessionUtils.setAttribute(Constants.Session.USER_TYPE, sysUserInfo.getUserType());
        SessionUtils.setAttribute(Constants.Session.USER_ID, sysUserInfo.getId());
        SessionUtils.setAttribute(Constants.Session.USER, JSONUtil.toJSONString(sysUserInfo));
        service.setAdmin(ConfigUtil.PLATFORM_APPID);
    }

}
