
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class LambdaThreadApp {


    private static final Logger logger = Logger.getLogger (LambdaThreadApp.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        Runnable myRunnable = () -> {

            try {

                while (true){

                    logger.info ("Lambda thread running");
                    Thread.sleep (5000);
                }

            } catch (Exception e){}
        };

        Thread thread = new Thread (myRunnable);
        thread.start();

        logger.debug ("Thread started!");
    }
}