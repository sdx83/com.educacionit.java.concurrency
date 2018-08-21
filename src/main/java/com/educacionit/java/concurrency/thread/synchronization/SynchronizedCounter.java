
package com.educacionit.java.concurrency.thread.synchronization;


public class SynchronizedCounter {


    private int count = 0;


    public SynchronizedCounter () {

        super ();
    }


    public synchronized void increment () {

        this.count = this.count + 1;
    }


    public int getCount () {

        return this.count;
    }
}
