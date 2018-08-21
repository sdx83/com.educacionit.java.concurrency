
package com.educacionit.java.concurrency.thread.lock;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.log4j.Logger;


public class ReadWriteLockExample {


    private static final Logger logger = Logger.getLogger (ReadWriteLockExample.class);


    public static void main (String[] args) {


        /*
         * Create a executor.
         * */
        logger.info ("Creating a executor...");
        ExecutorService executorService = Executors.newFixedThreadPool (3);



        /*
         *  Create a lock counter class.
         * */
        logger.info ("Creating a lock counter class...");
        ReadWriteCounter counter = new ReadWriteCounter ();



        /*
         *  Submit a thread.
         * */
        logger.info ("Create a read thread...");
        Runnable readTask = () -> logger.debug (Thread.currentThread ().getName () +
                  " Read Task : " + counter.getCount ());



        /*
         *  Submit a thread.
         * */
        logger.info ("Create a write thread...");
        Runnable writeTask = () -> logger.debug (Thread.currentThread().getName() +
                    " Write Task : " + counter.incrementAndGetCount ());



        /*
         *  Submit a threads.
         * */
        logger.info ("Submit a read threads...");
        executorService.submit (readTask);
        executorService.submit (readTask);

        /*
         *  Submit a thread.
         * */
        logger.info ("Submit a write thread...");
        executorService.submit (writeTask);

        /*
         *  Submit a threads.
         * */
        logger.info ("Submit a read threads...");
        executorService.submit (readTask);
        executorService.submit (readTask);



        /*
         *  Shutdown executor.
         * */
        logger.info ("Shutdown the executor...");
        executorService.shutdown ();
    }
}


class ReadWriteCounter {


    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private int count = 0;


    public ReadWriteCounter () {

        super ();
    }


    public int incrementAndGetCount () {

        lock.writeLock ().lock ();

        try {

            this.count = this.count + 1;
            return this.count;

        } finally {

            this.lock.writeLock ().unlock ();
        }
    }

    public int getCount() {

        this.lock.readLock ().lock ();

        try {

            return this.count;

        } finally {

            this.lock.readLock ().unlock ();
        }
    }
}