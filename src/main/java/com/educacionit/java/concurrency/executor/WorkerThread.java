
package com.educacionit.java.concurrency.executor;


import org.apache.log4j.Logger;


public class WorkerThread implements Runnable {


    private String command;


    private static final Logger logger = Logger.getLogger (WorkerThread.class);


    public WorkerThread (String command){

        this.command = command;
    }


    @Override
    public void run () {

        logger.debug (Thread.currentThread ().getName() + " Start. Command = " + command);
        processCommand ();
        logger.debug (Thread.currentThread ().getName () + " End.");
    }

    @Override
    public String toString () {

        return this.command;
    }


    private void processCommand () {

        try {

            Thread.sleep (5000);

        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}