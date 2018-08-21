
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class AnonymousThreadApp {


    private static final Logger logger = Logger.getLogger (AnonymousThreadApp.class);


    public static void main (String[] args) {

        logger.debug ("Starting threads...");
        Runnable myRunnable = new Runnable () {

            public void run () {

                try {

                    while (true){

                        logger.info ("Anonymous thread running");
                        Thread.sleep (5000);
                    }

                } catch (Exception e) {}
            }
        };

        Thread thread = new Thread (myRunnable);
        thread.start();

        logger.debug ("Thread started!");
    }
}