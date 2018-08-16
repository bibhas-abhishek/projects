package com.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.app.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.app.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.app.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("Executing @Before advice in method: " + joinPoint.getSignature().toShortString());
        for (Object arg : joinPoint.getArgs()) {
            logger.info("arg: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Executing @AfterReturning advice in method: " + joinPoint.getSignature().toShortString());
        logger.info("result: " + result);
    }

}
