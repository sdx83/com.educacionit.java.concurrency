
package com.educacionit.java.concurrency.thread.lock.bank.part1;


import java.util.HashMap;


public class Bank {


    private static Bank instance = new Bank ();
    private HashMap<Integer, BankAccount> accountNumberVsAccount;


    private Bank () {

        accountNumberVsAccount = new HashMap<> ();
        accountNumberVsAccount.put (123456, new BankAccount(123456));
    }


    public BankAccount getAccount (Integer accountNumber) {

        return this.accountNumberVsAccount.get (accountNumber);
    }


    public static Bank getInstance () {

        return instance;
    }
}
