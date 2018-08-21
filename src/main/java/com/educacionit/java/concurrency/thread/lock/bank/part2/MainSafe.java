
package com.educacionit.java.concurrency.thread.lock.bank.part2;


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
        Thread thread1 = new Thread (customer1);
        Thread thread2 = new Thread (customer2);



        /*
         * Starting threads.
         * */
        logger.info ("Starting threads customers..");
        thread1.setName ("Homer Simpson");
        thread2.setName ("Marge Simpson");
        thread1.start ();
        thread2.start ();
    }
}
