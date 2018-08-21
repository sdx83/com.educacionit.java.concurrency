
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThreadApp4 {


    private static final Logger logger = Logger.getLogger (MyThreadApp4.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        new MyThread4 ("eBay").run ();
        new MyThread4 ("Paypal").run ();
        new MyThread4 ("Google").run ();
        logger.debug ("Thread started!");
    }
}