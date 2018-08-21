
package com.educacionit.java.concurrency.thread.synchronization;


import org.apache.log4j.Logger;


public class MemoryConsistencyError {


    private static final Logger logger = Logger.getLogger (MemoryConsistencyError.class);

    private static boolean isTrue = false;


    public static void main(String[] args) throws InterruptedException {


        /*
         * Create a new threads.
         * */
        logger.info ("Creating new thread!");

        Thread thread = new Thread (() -> {

            while (!isTrue) {}

            logger.debug ("Hello Thread!");

            while(isTrue) {}

            logger.debug ("Good Bye! This is the End ...");
        });



        /*
         * Start a new thread.
         * */
        logger.info ("Starting new thread!");

        thread.start ();



        /*
         * Sleep the thread.
         * */
        Thread.sleep (1000);
        logger.info ("Sleeping the thread");
        isTrue = true;

        Thread.sleep (1000);
        logger.info ("Finishing main thread...");
        isTrue = false;
    }
}