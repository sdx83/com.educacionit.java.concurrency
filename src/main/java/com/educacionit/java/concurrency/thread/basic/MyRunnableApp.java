
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyRunnableApp {


    private static final Logger logger = Logger.getLogger (MyRunnableApp.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        Thread myRunnable = new Thread (new MyRunnable ());
        myRunnable.start ();
        logger.debug ("Thread started!");
    }
}