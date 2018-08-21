
package com.educacionit.java.concurrency.thread.synchronization;


import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;

public class MutexTest {


    private static final Logger logger = Logger.getLogger (SemaphoreTest.class);

    // max 1 people
    static Semaphore semaphore = new Semaphore(1);
    

    static class MyLockerThread extends Thread {

        String name = "";

        MyLockerThread(String name) {
            this.name = name;
        }

        public void run() {

            try {

                logger.info(name + " : acquiring lock...");
                logger.info(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                logger.info(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        logger.info(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    logger.info(name + " : releasing lock...");
                    semaphore.release();
                    logger.info(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        logger.info("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyLockerThread t1 = new MyLockerThread("A");
        t1.start();

        MyLockerThread t2 = new MyLockerThread("B");
        t2.start();

        MyLockerThread t3 = new MyLockerThread("C");
        t3.start();

        MyLockerThread t4 = new MyLockerThread("D");
        t4.start();

        MyLockerThread t5 = new MyLockerThread("E");
        t5.start();

        MyLockerThread t6 = new MyLockerThread("F");
        t6.start();

    }
}