
package com.educacionit.java.concurrency.executor;


import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;


public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {


    private static final Logger logger = Logger.getLogger (RejectedExecutionHandlerImpl.class);


    @Override
    public void rejectedExecution (Runnable r, ThreadPoolExecutor executor) {

        logger.error (r.toString() + " was rejected");
    }

}