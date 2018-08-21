
package com.educacionit.java.concurrency.future;


import java.util.concurrent.*;

import org.apache.log4j.Logger;


public class FutureCancelExample {


    private static final Logger logger = Logger.getLogger (FutureCancelExample.class);


    public static void main (String[] args) throws InterruptedException, ExecutionException {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newSingleThreadExecutor ();



        /*
         * Create a callable.
         * */
        logger.info ("Creating a callable...");
        Callable<String> callable = () -> {

            // Perform some computation
            Thread.sleep(4000);
            return "Answers from Callable";
        };



        /*
         * Submit a callable.
         * */
        logger.info ("Submitting Callable.");
        long startTime = System.nanoTime ();
        Future<String> future = executorService.submit (callable);



        /*
         * Checking the callable.
         * */
        logger.info ("Checking the Callable.");
        while(!future.isDone ()) {

            logger.debug ("Task is still not done...");
            Thread.sleep (200);
            double elapsedTimeInSec = (System.nanoTime() - startTime) / 1000000000.0;

            if (elapsedTimeInSec > 1) {

                /*
                 * Cancel future if the elapsed time is more than one second
                 */
                logger.warn ("cancelling task !!!");
                future.cancel (true);
            }
        }



        /*
         * Checking the callable.
         * */
        logger.info ("Checking if future is cancelled before retrieving the result...");
        if (!future.isCancelled ()) {

            logger.info ("Task completed! Retrieving the result");
            String result = future.get();
            logger.info (String.format ("Result got: %s", result));

        } else {

            logger.warn ("Task was cancelled !!!");
        }



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown executor.");
        executorService.shutdown ();
    }

}
