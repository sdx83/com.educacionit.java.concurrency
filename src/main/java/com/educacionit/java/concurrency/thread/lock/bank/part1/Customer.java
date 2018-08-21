
package com.educacionit.java.concurrency.thread.lock.bank.part1;


public class Customer implements Runnable {


    public Customer () {

        super ();
    }


    @Override
    public void run () {

        Bank bank = Bank.getInstance ();
        BankAccount account = bank.getAccount (123456);
        account.deposit (100);
        account.withdraw (200);
    }
}