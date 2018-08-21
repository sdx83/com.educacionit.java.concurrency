
package com.educacionit.java.concurrency.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;


public class ReentrantLockMethodsExample {


    private static final Logger logger = Logger.getLogger (ReentrantLockMethodsExample.class);

    public static void main (String[] args) {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newFixedThreadPool (2);



        /*
         *  Create a lock counter class.
         * */
        logger.info ("Creating a lock counter class...");
        ReentrantLockMethodsCounter lockMethodsCounter = new ReentrantLockMethodsCounter ();



        /*
         *  Submit a thread.
         * */
        logger.info ("Submit a thread...");
        executorService.submit(() -> {

            logger.debug (String.format ("IncrementCount (First Thread) : %d",
                   lockMethodsCounter.incrementAndGet ()));
        });



        /*
         *  Submit a threads.
         * */
        logger.info ("Submit a threads...");
        executorService.submit(() -> {

            logger.debug (String.format ("IncrementCount (Second Thread) : %d ",
                    lockMethodsCounter.incrementAndGet ()));
        });



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown the executor...");
        executorService.shutdown ();
    }
}



class ReentrantLockMethodsCounter {

    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;


    private static final Logger logger = Logger.getLogger (ReentrantLockMethodsCounter.class);


    public ReentrantLockMethodsCounter () {

        super ();
    }


    public int incrementAndGet () {


        /*
         * Check if the lock is currently acquired by any thread
         */
        logger.debug ("IsLocked : " + lock.isLocked ());

        /*
         * Check if the lock is acquired by the current thread itself.
         */
        logger.debug ("IsHeldByCurrentThread : " + lock.isHeldByCurrentThread ());



        /*
         * Try to acquire the lock
         */
        boolean isAcquired;

        try {

            isAcquired = lock.tryLock (1, TimeUnit.SECONDS);
            logger.debug ("Lock Acquired : " + isAcquired);

        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        if (isAcquired) {

            try {
                Thread.sleep(2000);
                count = count + 1;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                lock.unlock ();
            }
        }

        return count;
    }
}
