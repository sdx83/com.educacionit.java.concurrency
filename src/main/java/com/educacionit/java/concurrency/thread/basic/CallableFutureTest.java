
package com.educacionit.java.concurrency.thread.basic;


import org.apache.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class CallableFutureTest {


    private static final Logger logger = Logger.getLogger (CallableFutureTest.class);


    public static void main(String[] args) throws Exception
    {

        FutureTask[] randomNumberTasks = new FutureTask[5];

        for (int i = 0; i < 5; i++)
        {
            Callable callable = new CallableExample();

            randomNumberTasks[i] = new FutureTask(callable);

            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        for (int i = 0; i < 5; i++)
        {
            logger.info (randomNumberTasks[i].get());
        }
    }
}
