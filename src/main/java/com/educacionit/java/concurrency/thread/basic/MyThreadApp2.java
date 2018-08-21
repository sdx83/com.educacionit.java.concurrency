
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThreadApp2 {


    private static final Logger logger = Logger.getLogger (MyThreadApp2.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        MyThread2 myThread = new MyThread2 ("Educacion IT");
        myThread.start ();
        logger.debug ("Thread started!");
    }
}