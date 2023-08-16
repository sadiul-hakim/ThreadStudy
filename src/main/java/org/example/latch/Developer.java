package org.example.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Developer implements Runnable{
    private final CountDownLatch latch;

    public Developer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Done development.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.latch.countDown();
    }
}
