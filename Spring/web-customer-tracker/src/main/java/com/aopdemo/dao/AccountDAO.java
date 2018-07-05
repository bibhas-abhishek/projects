package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": Running add account");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": Running do work");
        return false;
    }

}
