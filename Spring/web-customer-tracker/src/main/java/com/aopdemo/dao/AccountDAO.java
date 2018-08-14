package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": Running add account");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": Running do work");
        return false;
    }

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("tripWire exception");
        }
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Jane", "Platinum"));
        accounts.add(new Account("Lucas", "Gold"));
        return accounts;
    }

}
