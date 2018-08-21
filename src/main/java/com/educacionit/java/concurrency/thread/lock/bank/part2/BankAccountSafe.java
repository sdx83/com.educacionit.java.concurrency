
package com.educacionit.java.concurrency.thread.lock.bank.part2;


import org.apache.log4j.Logger;


public class BankAccountSafe {


    private Integer balance;
    private Integer accountNumber;

    private static final Logger logger = Logger.getLogger (BankAccountSafe.class);


    public BankAccountSafe (Integer accountNumber, Integer initialBalance) {
        this.accountNumber = accountNumber;
        this.balance       = initialBalance;
    }

    public BankAccountSafe (Integer accountNumber) {

        this(accountNumber, 0);
    }


    public Integer getBalance () {

        return this.balance;
    }

    public Integer getAccountNumber () {

        return this.accountNumber;
    }

    public synchronized void deposit (Integer amount) {

        balance = balance + amount;
        logger.debug (amount + " deposited by : " + Thread.currentThread ().getName( ) + ", updated balance: " + balance);
    }

    public synchronized Integer withdraw (Integer amount) {

        logger.debug (Thread.currentThread ().getName () + " is trying to withdraw amount: " + amount + " from account: " + accountNumber);

        if (amount > balance) {

            logger.warn ("not enough balance in account: " + accountNumber + " to withdraw");
            logger.warn ("returning zero to: " + Thread.currentThread ().getName ());
            return 0;
        }

        this.balance = this.balance - amount;

        logger.debug (Thread.currentThread ().getName () + " successfully withdraw aomunt: " + amount + " from account: " + accountNumber);
        logger.debug ("updated balance: " + balance);

        return amount;
    }
}