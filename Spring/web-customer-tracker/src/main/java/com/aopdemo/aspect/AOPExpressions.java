package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExpressions {

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    public void daoPointCut() {
    }

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    public void getPointCut() {
    }

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    public void setPointCut() {
    }

    @Pointcut("daoPointCut() && !(getPointCut() || setPointCut())")
    public void forDaoPackageNotGetterSetter() {
    }

}
