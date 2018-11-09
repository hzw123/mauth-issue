package cn.mauth.issue.boss.aspect;

import cn.mauth.issue.boss.utils.HttpUtils;
import cn.mauth.issue.util.annotation.Api;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
    @Pointcut("execution(public * cn.mauth.issue.boss.controller.admin.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void webBefore(JoinPoint joinPoint){
        show(joinPoint);
    }

    @Before("@annotation(api)")
    public void apiLog(JoinPoint joinPoint, Api api){
        logger.info(api.getName());
        logger.info(api.value());
        show(joinPoint);
    }

    private void show(JoinPoint joinPoint){
        String method=joinPoint.getSignature().getName();
        Object[] objs=joinPoint.getArgs();
        String typename=joinPoint.getSignature().getDeclaringTypeName();
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String uri=request.getRequestURI();
        String requestMethod=request.getMethod();
        String account=null;
        if(HttpUtils.isUser()){
            account= HttpUtils.getAccount();
        }
        logger.info("\n{\tAccount:"+account+",\n\tURI:"+uri+",\n\t请求方式:"+requestMethod+",\n\t类:"+typename+",\n\t方法:"+method+",\n\t参数:"+ Arrays.toString(objs)+"\n}");
    }
}
