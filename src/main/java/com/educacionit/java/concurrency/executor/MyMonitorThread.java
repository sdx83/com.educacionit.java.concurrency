
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;


public class MyMonitorThread implements Runnable {


    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run = true;


    private static final Logger logger = Logger.getLogger (MyMonitorThread.class);


    public MyMonitorThread (ThreadPoolExecutor executor, int delay) {

        super ();

        this.executor = executor;
        this.seconds  = delay;
    }


    public void shutdown () {

        this.run = false;
    }

    @Override
    public void run () {

        while (run){

            logger.debug (String.format("[Monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                this.executor.getPoolSize (),
                this.executor.getCorePoolSize (),
                this.executor.getActiveCount (),
                this.executor.getCompletedTaskCount (),
                this.executor.getTaskCount (),
                this.executor.isShutdown (),
                this.executor.isTerminated ()));

            try {

                Thread.sleep (seconds * 1000);

            } catch (InterruptedException e) {

                e.printStackTrace ();
            }
        }
    }
}