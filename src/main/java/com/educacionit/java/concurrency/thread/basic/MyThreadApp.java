
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThreadApp {


    private static final Logger logger = Logger.getLogger (MyThreadApp.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        MyThread myThread = new MyThread ();
        myThread.start ();
        logger.debug ("Thread started!");
    }
}