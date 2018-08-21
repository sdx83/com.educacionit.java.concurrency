
package com.educacionit.java.concurrency.thread.lock;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;


import org.apache.log4j.Logger;


public class ReentrantLockExample {


    private static final Logger logger = Logger.getLogger (ReentrantLockExample.class);


    public static void main (String[] args) throws InterruptedException {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newFixedThreadPool (5);



        /*
         *  Create a lock counter class.
         * */
        logger.info ("Creating a lock counter class...");
        ReentrantLockCounter counter = new ReentrantLockCounter ();



        /*
         *  Submit a thread.
         * */
        logger.info ("Submit a thread...");
        executorService.submit(() -> counter.increment());



        /*
         *  Submit a threads.
         * */
        logger.info ("Submit a threads...");
        for (int i = 0; i < 10; i++) {

            executorService.submit (() -> counter.increment ());
        }



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown the executor...");
        executorService.shutdown ();
        executorService.awaitTermination (60, TimeUnit.SECONDS);

        logger.info (String.format ("Final count is %d ", counter.getCount ()));
    }
}



class ReentrantLockCounter {


    private final ReentrantLock lock = new ReentrantLock();

    private int count = 0;


    public ReentrantLockCounter () {

        super ();
    }


    public void increment () {

        lock.lock ();
        try {

            this.count = this.count + 1;

        } finally {
            lock.unlock ();
        }
    }

    public int getCount () {

        return this.count;
    }

}