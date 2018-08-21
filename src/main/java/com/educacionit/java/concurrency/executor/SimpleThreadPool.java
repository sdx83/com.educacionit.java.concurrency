
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;


public class SimpleThreadPool {


    private static final Logger logger = Logger.getLogger (WorkerThread.class);


    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool (5);

        for (int i = 0; i < 10; i++) {

            Runnable worker = new WorkerThread ("ls -a" + i);
            executor.execute (worker);
        }

        executor.shutdown ();

        while (!executor.isTerminated()) {}
        System.out.println ("Finished all threads");
    }

}