
package com.educacionit.java.concurrency.thread.lock;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;


public class AtomicIntegerExample {


    private static final Logger logger = Logger.getLogger (AtomicIntegerExample.class);


    public static void main (String[] args) throws InterruptedException {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newFixedThreadPool (2);


        /*
         *  Create a atomic class.
         * */
        logger.info ("Creating a atomic class.");
        AtomicCounter atomicCounter = new AtomicCounter ();



        /*
         *  Submit threads.
         * */
        logger.info ("Submit threads.");
        for (int i = 0; i < 1000; i++) {

            executorService.submit ( () -> atomicCounter.incrementAndGet ());
        }



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown executor.");
        executorService.shutdown ();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        logger.info (String.format ("Final Count is %d ", atomicCounter.getCount ()));
    }
}


class AtomicCounter {


    private AtomicInteger count = new AtomicInteger(0);


    public AtomicCounter () {

        super ();
    }


    public int incrementAndGet () {

        return this.count.incrementAndGet ();
    }

    public int getCount () {

        return this.count.get ();
    }
}