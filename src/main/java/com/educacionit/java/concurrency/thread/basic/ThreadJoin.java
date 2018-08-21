
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class ThreadJoin {


    private static final Logger logger = Logger.getLogger (AnonymousThreadApp.class);


    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {

            logger.debug ("Entered Thread 1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            logger.debug ("Exiting Thread 1");
        });


        Thread thread2 = new Thread(() -> {

            logger.debug ("Entered Thread 2");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            logger.debug ("Exiting Thread 2");
        });


        logger.info ("Starting Thread 1");
        thread1.start();


        logger.warn ("Waiting for Thread 1 to complete");
        try {

            thread1.join(1000);

        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        logger.info ("Waited enough! Starting Thread 2 now");
        thread2.start ();
    }
}