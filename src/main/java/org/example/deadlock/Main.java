package org.example.deadlock;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();

        Thread running = new Thread(()->{
            deadLock.running();
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });

        Thread walking = new Thread(()->{
            deadLock.walking();
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });

        running.start();
        walking.start();

        running.join();
        walking.join();

    }
}
