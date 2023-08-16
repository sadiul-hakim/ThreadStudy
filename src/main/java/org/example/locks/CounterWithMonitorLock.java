package org.example.locks;

public class CounterWithMonitorLock {
    private int count;

    public synchronized void increment(int value){
        count += value;
    }
}
