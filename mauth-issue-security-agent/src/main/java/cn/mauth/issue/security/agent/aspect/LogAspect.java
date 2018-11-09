package cn.mauth.issue.security.agent.aspect;

import cn.mauth.issue.util.annotation.Api;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class LogAspect {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(api)")
    public void apiLog(JoinPoint joinPoint, Api api){
        show(joinPoint,api);
    }

    private void show(JoinPoint joinPoint,Api api){
        String method=joinPoint.getSignature().getName();
        Object[] objs=joinPoint.getArgs();
        String typename=joinPoint.getSignature().getDeclaringTypeName();
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String uri=request.getRequestURI();
        String requestMethod=request.getMethod();
        logger.info("\n{\tapi-name:"+api.getName()+",\n\tapi-value:"+api.value()+",\n\tURI:"+uri+",\n\t请求方式:"+requestMethod+",\n\t类:"+typename+",\n\t方法:"+method+",\n\t参数:"+ Arrays.toString(objs)+"\n}");
    }
}
