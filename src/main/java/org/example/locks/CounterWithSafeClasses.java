package org.example.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterWithSafeClasses {
    private AtomicInteger counter;

    public void increment(int value){
        counter.addAndGet(value);
    }

    public int get(){
        return counter.get();
    }
}
