package org.example.latch;

import java.util.concurrent.CountDownLatch;

public class Tester implements Runnable{
    private final CountDownLatch latch;

    public Tester(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done Testing.");
    }
}
