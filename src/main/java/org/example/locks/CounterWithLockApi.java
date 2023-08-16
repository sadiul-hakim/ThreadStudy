package org.example.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterWithLockApi {
    private int count;

    // kind of explicit lock
    private final Lock lock = new ReentrantLock();

    public void increment(int value) {

        // tryLock() is better than lock() , monitor lock. It Defences Deadlock.
        // It does not block the thread. It tries to acquire the lock again and again
        boolean locked = lock.tryLock();
        System.out.println("Lock acquired: "+locked);

        try {
            count += value;
        } catch (Exception ignored) {

        } finally {
            lock.unlock();
        }

    }
}
