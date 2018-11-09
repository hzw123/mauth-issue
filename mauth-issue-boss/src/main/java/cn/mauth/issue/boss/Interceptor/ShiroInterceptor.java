package cn.mauth.issue.boss.Interceptor;

import cn.mauth.issue.boss.utils.SessionUtils;
import cn.mauth.issue.util.JSONUtil;
import cn.mauth.issue.util.base.BaseRoncoo;
import cn.mauth.issue.util.bjui.Bjui;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 权限拦截器
 */
@Component
public class ShiroInterceptor extends BaseRoncoo implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getServletPath();
        if (!checkUri(uri)) {
            logger.error("没此权限，当前访问路径为：{}", uri);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            Bjui bj = new Bjui();
            bj.setStatusCode(300);
            bj.setMessage("没此权限，请联系管理员！");
            out.print(JSONUtil.toJSONString(bj));
            out.flush();
            out.close();
            return false;
        }
        return true;
    }

    private static Boolean checkUri(String uri) {
        if (StringUtils.hasText(uri) && uri.endsWith("/")) {
            uri = uri.substring(0, uri.length() - 1);
        }
        for (String s : SessionUtils.getPermissions()) {
            if (s.contains(uri)) {
                return true;
            }
        }
        return false;
    }

}
