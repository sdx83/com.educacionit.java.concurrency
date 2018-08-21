
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThreadApp3 {


    private static final Logger logger = Logger.getLogger (MyThreadApp3.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        MyThread2 myThread = new MyThread2 ("Educacion IT");
        myThread.start ();
        logger.info (String.format ("Main thread name : [%s]", Thread.currentThread().getName ()));
        logger.debug ("Thread started!");
    }
}