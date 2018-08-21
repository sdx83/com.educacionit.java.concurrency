
package com.educacionit.java.concurrency.thread.lock.bank.part2;


public class CustomerSafe implements Runnable {


    public CustomerSafe () {

        super ();
    }


    @Override
    public void run () {

        Bank bank = Bank.getInstance ();
        BankAccountSafe account = bank.openNewAccount ();
        account.deposit (100);
        account.withdraw (200);
    }
}