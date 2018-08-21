
package com.educacionit.java.concurrency.thread.lock.bank.part1;


import org.apache.log4j.Logger;


public class BankAccount {


    private Integer balance;
    private Integer accountNumber;


    private static final Logger logger = Logger.getLogger (BankAccount.class);


    public BankAccount (Integer accountNumber, Integer initialBalance) {

        this.accountNumber = accountNumber;
        this.balance       = initialBalance;
    }


    public BankAccount (Integer accountNumber) {

        this (accountNumber, 0);
    }


    public Integer getBalance () {

        return this.balance;
    }

    public Integer getAccountNumber () {

        return this.accountNumber;
    }

    public void deposit (Integer amount) {

        balance = balance + amount;
        logger.debug (Thread.currentThread ().getName () + " depositing the amount " + amount + " updated balance =  " + balance);
    }

    public Integer withdraw(Integer amount) {

        logger.debug (Thread.currentThread ().getName () + " trying to withdraw " + amount + " from the account " + accountNumber);

        if (balance < amount) {

            logger.warn ("OOPS, NO BALANCE LEFT TO WITHDRAW FOR "+Thread.currentThread ().getName ());
            return 0;
        }

        balance = balance - amount;

        logger.debug (Thread.currentThread ().getName () + " successfully withdraw the amount. balance left =  " + balance);
        return amount;
    }
}