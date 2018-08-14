package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class APIAnalyticsAspect {

    @Before("com.aopdemo.aspect.AOPExpressions.forDaoPackageNotGetterSetter()")
    public void performAnalytics() {
        System.out.println("Performing API analytics @Before advice");
    }

}
