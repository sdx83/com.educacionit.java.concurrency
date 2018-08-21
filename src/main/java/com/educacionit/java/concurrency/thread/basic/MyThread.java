
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThread extends Thread {


    private static final Logger logger = Logger.getLogger (MyThread.class);


    public MyThread () {

        super ();
    }


    public void run () {

        try {

            while (true){

                logger.info ("MyThread running");
                Thread.sleep (5000);
            }

        } catch (Exception e) {}
    }
}