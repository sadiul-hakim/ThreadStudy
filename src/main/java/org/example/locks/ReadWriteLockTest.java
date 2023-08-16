package org.example.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
    private int value;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public int getValue(){
        boolean b = lock.readLock().tryLock();

        try{
            return value;
        }finally {
            lock.readLock().unlock();
        }
    }

    public void writeLock(int newValue){
        boolean b = lock.writeLock().tryLock();

        try{
            value += newValue;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
