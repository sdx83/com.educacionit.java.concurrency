
package com.educacionit.java.concurrency.future;


import java.util.concurrent.*;

import org.apache.log4j.Logger;


public class FutureAndCallableExample {


    private static final Logger logger = Logger.getLogger (FutureAndCallableExample.class);


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

            // Perform some action.
	        logger.debug ("Entered Callable");
            Thread.sleep (4000);
            return "Answers from Callable";
        };



        /*
         * Submit a callable.
         * */
        logger.info ("Submitting Callable.");
	    Future<String> future = executorService.submit (callable);

	    logger.warn ("Do something else while callable is getting executed.");
        logger.info ("Retrieving the result of the future...");

        /*
         * Future.get() blocks until the result is available
         */
        String result = future.get ();
        logger.info (String.format ("Result from callable is \"%s\"", result));



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown executor.");
        executorService.shutdown ();
    }
}