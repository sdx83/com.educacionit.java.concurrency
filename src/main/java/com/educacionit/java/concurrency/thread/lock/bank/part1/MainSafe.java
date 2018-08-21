
package com.educacionit.java.concurrency.thread.lock.bank.part1;


import org.apache.log4j.Logger;


public class MainSafe {


    private static final Logger logger = Logger.getLogger (MainSafe.class);


    public static void main (String[] args) {


        /*
         * Create a customers.
         * */
        logger.info ("Creating new customers..");
        CustomerSafe customer1 = new CustomerSafe ();
        CustomerSafe customer2 = new CustomerSafe ();



        /*
         * Creating new threads.
         * */
        logger.info ("Creating new customers..");
        Thread t1 = new Thread (customer1);
        Thread t2 = new Thread (customer2);

        t1.setName ("Homer Simpson");
        t2.setName ("Mare Simpson");



        /*
         * Starting threads.
         * */
        logger.info ("Starting threads customers..");
        t1.start ();
        t2.start ();
    }
}