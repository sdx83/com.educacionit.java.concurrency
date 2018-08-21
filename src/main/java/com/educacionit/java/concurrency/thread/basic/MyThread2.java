
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;


public class MyThread2 extends Thread {


    private static final Logger logger = Logger.getLogger (MyThread2.class);


    public MyThread2 (String name) {

        super (name);
    }


    public void run () {

        try {

            while (true){

                logger.info (String.format ("%s running", this.getName ()));
                Thread.sleep (5000);
            }

        } catch (Exception e) {}
    }
}