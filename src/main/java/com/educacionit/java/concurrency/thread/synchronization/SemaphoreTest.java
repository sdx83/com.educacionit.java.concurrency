
package com.educacionit.java.concurrency.thread.synchronization;


import java.util.concurrent.Semaphore;

import org.apache.log4j.Logger;


public class SemaphoreTest {


    private static final Logger logger = Logger.getLogger (SemaphoreTest.class);
    
    // max 4 people
    static Semaphore semaphore = new Semaphore(4);

    static class MyATMThread extends Thread {

        String name = "";

        MyATMThread(String name) {
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

        MyATMThread t1 = new MyATMThread("A");
        t1.start();

        MyATMThread t2 = new MyATMThread("B");
        t2.start();

        MyATMThread t3 = new MyATMThread("C");
        t3.start();

        MyATMThread t4 = new MyATMThread("D");
        t4.start();

        MyATMThread t5 = new MyATMThread("E");
        t5.start();

        MyATMThread t6 = new MyATMThread("F");
        t6.start();

    }
}
