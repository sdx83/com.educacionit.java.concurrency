
package com.educacionit.java.concurrency.thread.lock.bank.part2;


import java.util.HashMap;


public class Bank {

    private static Bank instance = new Bank ();
    private HashMap<Integer, BankAccountSafe> accountNumberVsAccount;


    private Bank () {

        this.accountNumberVsAccount = new HashMap<> ();
        this.accountNumberVsAccount.put(123456, new BankAccountSafe (123456));
    }


    public BankAccountSafe openNewAccount () {

        return new BankAccountSafe (123456);
    }

    public BankAccountSafe getAccount (Integer accountNumber) {

        return this.accountNumberVsAccount.get (accountNumber);
    }


    public static Bank getInstance (){

        return instance;
    }
}
