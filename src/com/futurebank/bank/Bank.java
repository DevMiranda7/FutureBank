package com.futurebank.bank;

import com.futurebank.account.Account;
import com.futurebank.client.AccountHolder;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }


    //CREATE
    public void createAccount(AccountHolder holder){
        Account newAccount = new Account();
        newAccount.setTitular(holder);
        accounts.add(newAccount);
        System.out.println("com.com.futurebank.account.Account created successfully!");
    }
    //READ
    public Account accountInformation(int number){
        for(Account findAccount : accounts){
            if (findAccount.getNumero() == number){
                return findAccount;
            }
        }
        return null;
    }
    //UPDATE
    public void updateAccount(int number, AccountHolder updateHolder){
        Account upAccount = accountInformation(number);
        if(upAccount != null){
            upAccount.setTitular(updateHolder);
            int index = accounts.indexOf(upAccount);
            accounts.set(index, upAccount);
            System.out.println("com.com.futurebank.account.Account updated successfully!");
        }
        else{
            System.out.println("com.com.futurebank.account.Account update failed!");
        }
    }
    //DELETE
    public void deleteAccount(int number){
        Account delAccount = accountInformation(number);
        if(delAccount != null){
            int index = accounts.indexOf(delAccount);
            accounts.remove(index);
            System.out.println("com.com.futurebank.account.Account removed successfully!");
        }
        else{
            System.out.println("com.com.futurebank.account.Account remove failed!");
        }
    }

}