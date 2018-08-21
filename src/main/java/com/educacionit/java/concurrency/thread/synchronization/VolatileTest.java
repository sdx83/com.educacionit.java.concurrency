
package com.educacionit.java.concurrency.thread.synchronization;


import org.apache.log4j.Logger;


public class VolatileTest {


    private static final Logger logger = Logger.getLogger (VolatileTest.class);

    private static volatile int MY_INT = 0;


    public static void main (String[] args) {

        /*
         * Starting threads.
         * */
        logger.info ("Starting threads...");
        new ChangeListener ().start ();
        new ChangeMaker ().start ();
    }


    static class ChangeListener extends Thread {


        public ChangeListener () {

            super ();
        }


        @Override
        public void run() {

            int local_value = MY_INT;

            while ( local_value < 5) {

                if( local_value!= MY_INT){

                    logger.debug (String.format ("Got Change for MY_INT : %d", MY_INT));
                    local_value= MY_INT;
                }
            }
        }
    }


    static class ChangeMaker extends Thread {


        public ChangeMaker () {

            super ();
        }


        @Override
        public void run () {

            int local_value = MY_INT;

            while (MY_INT <5) {

                logger.debug (String.format ("Incrementing MY_INT to %d", local_value + 1));
                MY_INT = ++local_value;

                try {

                    Thread.sleep (500);

                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}