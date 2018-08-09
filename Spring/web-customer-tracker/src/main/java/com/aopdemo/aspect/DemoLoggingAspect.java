package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void daoPointCut() {
    }

    @Before("daoPointCut()")
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice");
    }

}
