
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class FutureAndCallable {


    private static final Logger logger = Logger.getLogger (FutureAndCallable.class);


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {

            logger.debug ("Entered Callable");
            Thread.sleep(4000);
            return "Hello from Callable";
        };

        logger.info ("Submitting Callable");
        Future<String> future = executorService.submit(callable);

        logger.info ("Do something else while callable is getting executed");

        logger.info ("Retrieve the result of the future");

        String result = future.get();
        logger.info (result);

        executorService.shutdown();
    }
}