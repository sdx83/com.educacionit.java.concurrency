
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThread4 extends Thread {


    private static final Logger logger = Logger.getLogger (MyThread4.class);


    public MyThread4 (String name) {

        super (name);
    }


    public void run () {

        for (int i = 0; i < 5; i++) {

            logger.debug (String.format ("Loop %d %s ",i, getName()));
            try {
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
            }
        }
        logger.info (String.format ("Test Finished for %s ", getName()));
    }
}