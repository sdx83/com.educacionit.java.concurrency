
package com.educacionit.java.concurrency.thread.synchronization;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


public class SynchronizedRaceCondition {


    private static final Logger logger = Logger.getLogger (SynchronizedRaceCondition.class);


    public static void main (String[] args) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool (10);

        SynchronizedCounter synchronizedCounter = new SynchronizedCounter ();

        for (int i = 0; i < 1000; i++) {

            executorService.submit (() -> synchronizedCounter.increment ());
        }

        executorService.shutdown ();
        executorService.awaitTermination (60, TimeUnit.SECONDS);

        logger.info ("Final count is : " + synchronizedCounter.getCount ());
    }
}