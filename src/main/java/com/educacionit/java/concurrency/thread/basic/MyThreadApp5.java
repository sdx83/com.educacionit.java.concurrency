
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThreadApp5 {


    private static final Logger logger = Logger.getLogger (MyThreadApp5.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        new MyThread4 ("eBay").start ();
        new MyThread4 ("Paypal").start ();
        new MyThread4 ("Google").start ();
        logger.debug ("Thread started!");
    }
}