package com.geek.web.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @version V1.0
 * @description: WebLogConfig Config
 * @author: geek
 * @date 2021/04/11
 **/
@Slf4j
@Aspect
@Configuration
public class WebLogConfig {

    /**
     * 以请求 annotation 作为切入点
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping) " +
            "|| @annotation(org.springframework.web.bind.annotation.GetMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PostMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.PathVariable)" +
            "|| @annotation(org.springframework.web.bind.annotation.PutMapping)" +
            "|| @annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void webLog() {
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        if (RequestLog.log.isDebugEnabled()) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            StringBuilder logInfo = null;
            /**
             * 请求相关参数
             * <1> url
             * <2> http method
             * <3> class method: controller 的全路径以及执行方法
             * <4> ip
             * <5> request args: 请求入参
             */
            logInfo = new StringBuilder();
            logInfo.append("\n\t ----------------------用户[{}]请求----------------------")
                    .append("\n\t url            : {}")
                    .append("\n\t http method    : {}")
                    .append("\n\t class method   : {}.{}")
                    .append("\n\t ip             : {}")
                    .append("\n\t request args   : {}")
                    .append("\n\t -------------------------------------------------------");
            RequestLog.log.debug(logInfo.toString(),
                    request.getRemoteUser(),
                    request.getRequestURL(),
                    request.getMethod(),
                    proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                    proceedingJoinPoint.getSignature().getName(),
                    request.getRemoteAddr(),
                    proceedingJoinPoint.getArgs());

            long startTime = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();

            /**
             * 请求相关参数
             * <1> 出参
             * <2> 执行耗时
             */
            logInfo = new StringBuilder();
            logInfo.append("\n\t ----------------------用户请求结果-----------------------")
                    .append("\n\t url            : {}")
                    .append("\n\t response args  : {}")
                    .append("\n\t time-consuming : {} ms")
                    .append("\n\t -------------------------------------------------------");
            RequestLog.log.debug(logInfo.toString(),
                    request.getRequestURL(),
                    result,
                    endTime - startTime);
        } else {
            result = proceedingJoinPoint.proceed();
        }
        return result;
    }

    @Slf4j
    public static class RequestLog {

    }
}
