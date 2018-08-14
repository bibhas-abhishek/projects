package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    @Around("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public Object aroundFindAccountsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Executing @Around on method: " + proceedingJoinPoint.getSignature().toShortString());
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            System.out.println("@Around advice exception: " + ex);
            return "Exception handled";
        }
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - begin));
        return result;
    }

    // runs before AfterThrowing
    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @After on method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "ex")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Intercepted @AfterReturning on method: " + joinPoint.getSignature().toShortString());
        System.out.println("Exception: " + ex);
    }

    @AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());
        System.out.println("Result: " + result);
        convertResultToUpperCase(result);
    }

    private void convertResultToUpperCase(List<Account> result) {
        for (Account account : result)
            account.setName(account.getName().toUpperCase());
    }

    @Before("com.aopdemo.aspect.AOPExpressions.forDaoPackageNotGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @Before advice");
        System.out.println("Signature: " + joinPoint.getSignature());
        Object[] args = joinPoint.getArgs();
        for (Object tempArgs : args) {
            System.out.println("Args: " + tempArgs);
            if (tempArgs instanceof Account) {
                Account account = (Account) tempArgs;
                System.out.println("AccountArgs: " + account);
            }
        }
    }

}
