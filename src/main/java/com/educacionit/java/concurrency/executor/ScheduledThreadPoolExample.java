
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


public class ScheduledThreadPoolExample {


    private static final Logger logger = Logger.getLogger (ScheduledThreadPoolExample.class);


    public static void main (String[] args) {


        /*
         * Create threads.
         * */
        logger.info (String.format ("Inside : %s", Thread.currentThread ().getName ()));

        Runnable run1 = () -> {

            try {

                logger.debug (String.format ("%s executing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));
                Thread.sleep (10000);
                logger.debug (String.format ("%s finishing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));

            } catch (Exception e) {}
        };

        Runnable run2 = () -> {

            try {

                logger.debug (String.format ("%s executing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));
                Thread.sleep (5000);
                logger.debug (String.format ("%s finishing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));

            } catch (Exception e) {}
        };

        Runnable run3 = () -> {

            try {

                logger.debug (String.format ("%s executing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));
                Thread.sleep (3000);
                logger.debug (String.format ("%s finishing task at %d ", Thread.currentThread ().getName (), System.nanoTime ()));

            } catch (Exception e) {}
        };



        /*
         * Create the executor task.
         * */

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool (5);



        /*
         * Execute the tasks.
         * */
        logger.info ("Submit a task 1 specified after 2 seconds.");
        executorService.schedule (run1, 2, TimeUnit.SECONDS);
        logger.info ("Task 1 specified after 2 seconds running.");

        logger.info ("Submit a task 2 specified after 2 seconds.");
        executorService.schedule (run2, 4, TimeUnit.SECONDS);
        logger.info ("Task 2 specified after 2 seconds running.");

        logger.info ("Submit a task 3 specified after 2 seconds.");
        executorService.schedule (run3, 6, TimeUnit.SECONDS);
        logger.info ("Task 3 specified after 2 seconds running.");



        /*
         * Shutdown the executor service.
         * */
        executorService.shutdown ();
    }
}