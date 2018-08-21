package com.educacionit.java.concurrency.thread.basic;

import org.apache.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {


    private static final Logger logger = Logger.getLogger (ExecutorsExample.class);


    public static void main(String[] args) {

        logger.info ("Inside : " + Thread.currentThread().getName());

        logger.info ("Creating Executor Service...");
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        logger.info ("Creating a Runnable...");
        Runnable runnable = () -> {
            logger.debug ("Inside : " + Thread.currentThread().getName());
        };

        logger.info("Submit the task specified by the runnable to the executor service.");
        executorService.submit(runnable);
    }

}
