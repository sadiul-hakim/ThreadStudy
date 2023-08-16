package org.example.locks;

public class CounterWithExplicitLock {
    private int count;
    private final Object lock = new Object();

    public synchronized void increment(int value){
        synchronized (lock){
            count += value;
        }
    }

    public int getCount() {
        return count;
    }
}
