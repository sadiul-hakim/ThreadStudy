package org.example.executorService;

public class ThreadUsingRunnable implements Runnable{

    private final int poolSize;

    public ThreadUsingRunnable(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getPoolSize() {
        return poolSize;
    }

    @Override
    public void run() {

    }
}
