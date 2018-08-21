
package com.educacionit.java.concurrency.future;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import org.apache.log4j.Logger;


public class InvokeAllExample {


    private static final Logger logger = Logger.getLogger (InvokeAllExample.class);


    public static void main (String[] args) throws InterruptedException, ExecutionException {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        /*
         * Create a callable.
         * */
        logger.info ("Create callable objects...");
        Callable<String> task1 = () -> {

            Thread.sleep (2000);
            return "Result of Task1";
        };

        Callable<String> task2 = () -> {

            Thread.sleep (1000);
            return "Result of Task2";
        };

        Callable<String> task3 = () -> {

            Thread.sleep (5000);
            return "Result of Task3";
        };


        /*
         * Invoke all callable objects.
         * */
        logger.info ("Submit callable objects...");
        List<Callable<String>> taskList = Arrays.asList (task1, task2, task3);
        List<Future<String>> futures = executorService.invokeAll (taskList);



        /*
         *  Getting results.
         * */
        logger.info ("Shutdown executor.");
        for (Future<String> future: futures) {

            /*
             *  The result is printed only after all the futures are complete.
             * */
            logger.info (future.get ());
        }


        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown executor.");
	    executorService.shutdown ();
    }
}