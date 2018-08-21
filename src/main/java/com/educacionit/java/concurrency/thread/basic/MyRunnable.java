
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyRunnable implements Runnable {


    private static final Logger logger = Logger.getLogger (MyRunnable.class);


    public MyRunnable () {

        super ();
    }


    public void run () {

        try {

            while (true){

                logger.info ("MyRunnable running");
                Thread.sleep (5000);
            }

        } catch (Exception e) {}
    }
}