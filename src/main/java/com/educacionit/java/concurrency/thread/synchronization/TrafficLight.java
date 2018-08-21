
package com.educacionit.java.concurrency.thread.synchronization;


import java.util.*;
import java.util.concurrent.*;

import org.apache.log4j.Logger;


public class TrafficLight {


    private static final Logger logger = Logger.getLogger (TrafficLight.class);


    public static void main (String[] args) {


        /*
         * Creating new thread.
         * */
        logger.info ("Creating new thread...");
        Runnable limitedCall = new Runnable () {

            final Random rand = new Random ();
            final Semaphore available = new Semaphore (3);
            int count = 0;

            public void run () {

                int time = rand.nextInt (15);
                int num = count++;

                try {

                    available.acquire ();

                    logger.debug ("Executing long-running action for " + time + " seconds... #" + num);
                    Thread.sleep (time * 1000);

                    logger.debug ("Done with #" + num + "!");
                    available.release ();

                } catch (InterruptedException intEx) {

                    intEx.printStackTrace ();
                }
            }
        };



        /*
         * Executing threads.
         * */
        logger.info ("Executing threads...");
        for (int i=0; i<10; i++) {

            new Thread (limitedCall).start();
        }
    }
}