package com.geek.web.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 请求日志 Config
 * @author: geek
 * @date 2021/04/11
 **/
@Slf4j
@Aspect
@Configuration
public class WebLogConfig {

    /**
     * 以 controller 包下定义的所有请求为切入点
     */
    @Pointcut("execution(public * com.geek.web.controller..*.*(..))")
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
                new Gson().toJson(proceedingJoinPoint.getArgs()));

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
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
                new Gson().toJson(result),
                endTime - startTime);
        return result;
    }

    @Slf4j
    public static class RequestLog {

    }
}
