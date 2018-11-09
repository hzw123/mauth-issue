package cn.mauth.issue.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

public final class HttpServletUtils {

    public static HttpServletResponse getResponse(){
        ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attr.getResponse();
    }
}
