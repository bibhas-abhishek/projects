package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        /*accountDAO.addAccount(new Account("test", "1"), true);
        accountDAO.doWork();

        accountDAO.setName("testName");
        accountDAO.setServiceCode("test sc");
        String name = accountDAO.getName();
        String sc = accountDAO.getServiceCode();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();*/

        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex);
        }
        System.out.println(accounts);
        context.close();
    }

}
