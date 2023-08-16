package org.example;


public class TestThread extends Thread{
    private volatile boolean running=true;
    @Override
    public void run() {
        while(running) {
            System.out.println("Inside Thread " + Thread.currentThread().getName());

            if (Thread.interrupted()) {
                System.out.println("Thread interrupted!");
                return;
            }
        }
    }

    public void shutdown(){
        running=false;
    }
}
