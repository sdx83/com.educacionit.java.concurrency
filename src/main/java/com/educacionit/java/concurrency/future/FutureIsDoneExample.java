
package com.educacionit.java.concurrency.future;


import java.util.concurrent.*;

import org.apache.log4j.Logger;


public class FutureIsDoneExample {


    private static final Logger logger = Logger.getLogger (FutureIsDoneExample.class);


    public static void main (String[] args) throws InterruptedException, ExecutionException {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newSingleThreadExecutor ();



        /*
         * Create a callable.
         * */
        logger.info ("Create and submit a callable...");
        Future<String> future = executorService.submit (() -> {

            Thread.sleep (2000);
            return "Answer from Callable";
        });



        /*
         * Checking the callable.
         * */
        logger.info ("Checking if future is cancelled before retrieving the result...");
        while(!future.isDone ()) {

            logger.debug ("Task is still not done...");
            Thread.sleep (200);
        }

        logger.info ("Task completed! Retrieving the result");
        String result = future.get ();
        logger.info (String.format ("Result got: %s", result));



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown executor.");
        executorService.shutdown();
    }

}
