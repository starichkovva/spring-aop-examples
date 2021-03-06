package org.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Vadim Starichkov
 * @since 19.12.2014
 */
@Aspect
public class AroundAspect extends AbstractAspect {

    @Pointcut(value = "execution(* org.starichkov.java.spring.aop.controller.AspectsController.showAround(javax.servlet.http.HttpServletRequest, String)) && args(request, arg))", argNames = "request, arg")
    public void showAround(HttpServletRequest request, String arg) {
    }

    @Around(value = "showAround(request, arg)", argNames = "joinPoint, request, arg")
    public Object aroundHandler(ProceedingJoinPoint joinPoint, HttpServletRequest request, String arg) throws Throwable {
        LOGGER.info("AROUND HANDLER - BEFORE showAround, ARG: " + arg);
        Object result = joinPoint.proceed();
        LOGGER.info("AROUND HANDLER - AFTER showAround, ARG: " + arg);
        LOGGER.info("AROUND HANDLER - AFTER showAround, RESULT: " + result);
        return result;
    }
}
