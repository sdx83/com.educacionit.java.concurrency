
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;


public class SingleThreadExecutorExample {


    private static final Logger logger = Logger.getLogger (SingleThreadExecutorExample.class);


    public static void main (String[] args) {


        /*
         * Create threads.
         * */
        logger.info (String.format ("Inside : %s", Thread.currentThread ().getName ()));

        Runnable run1 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                Thread.sleep (10000);

            } catch (Exception e) {}
        };

        Runnable run2 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                Thread.sleep (5000);

            } catch (Exception e) {}
        };

        Runnable run3 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                Thread.sleep (2000);

            } catch (Exception e) {}
        };

        Runnable[] runs = { run1, run2, run3 };



        /*
         * Create the executor task.
         * */

        ExecutorService executorService = Executors.newSingleThreadExecutor ();



        /*
         * Execute the tasks.
         * */
        for (Runnable item: runs) {

            logger.info ("Submit a new task specified by the runnable to the executor service.");
            executorService.submit (item);
            logger.info ("Task specified by the runnable to the executor service sent.");
        }



        /*
         * Shutdown the executor service.
         * */
        executorService.shutdown ();
    }
}