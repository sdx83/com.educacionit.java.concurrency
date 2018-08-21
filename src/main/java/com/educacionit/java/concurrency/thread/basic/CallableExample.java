package com.educacionit.java.concurrency.thread.basic;


import java.util.Random;
import java.util.concurrent.Callable;


public class CallableExample implements Callable
{

    public Object call() throws Exception
    {
        Random generator = new Random();
        Integer randomNumber = generator.nextInt(5);

        Thread.sleep(randomNumber * 3000);

        return randomNumber;
    }

}