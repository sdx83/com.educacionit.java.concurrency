
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


public class FixedThreadPoolExample {


    private static final Logger logger = Logger.getLogger (FixedThreadPoolExample.class);


    public static void main (String[] args) {


        /*
         * Create threads.
         * */
        logger.info (String.format ("Inside : %s", Thread.currentThread ().getName ()));

        Runnable run1 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                TimeUnit.SECONDS.sleep (2);

            } catch (Exception e) {}
        };

        Runnable run2 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                TimeUnit.SECONDS.sleep (4);

            } catch (Exception e) {}
        };

        Runnable run3 = () -> {

            try {

                logger.debug (String.format ("Inside : %s", Thread.currentThread ().getName ()));
                TimeUnit.SECONDS.sleep (3);

            } catch (Exception e) {}
        };

        Runnable[] runs = { run1, run2, run3 };



        /*
         * Create the executor task.
         * */

        ExecutorService executorService = Executors.newFixedThreadPool (2);



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