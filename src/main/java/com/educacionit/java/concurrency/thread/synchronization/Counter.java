
package com.educacionit.java.concurrency.thread.synchronization;


public class Counter {


    private int count = 0;


    public Counter () {

        super ();
    }


    public void increment () {

        this.count = this.count + 1;
    }

    public int getCount () {

        return this.count;
    }
}