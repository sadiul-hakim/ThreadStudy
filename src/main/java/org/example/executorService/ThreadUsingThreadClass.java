package org.example.executorService;

public class ThreadUsingThreadClass extends Thread{
    private final int poolSize;

    @Override
    public void run() {
        // do something
    }

    public ThreadUsingThreadClass(int poolSize) {
        this.poolSize = poolSize;
    }

    public int getPoolSize() {
        return poolSize;
    }


}
