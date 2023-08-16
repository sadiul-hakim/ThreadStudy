package org.example.waiting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueBuffer buffer = new BlockingQueueBuffer();

        Thread addingThread = new Thread(()->{
            for(int i=0 ; i<=1000 ; i++){
                buffer.addItem(i);
            }
        });

        Thread gettingThread = new Thread(()->{
            while(true){
                try {
                    buffer.getItem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        addingThread.start();
        gettingThread.start();

        addingThread.join();
        gettingThread.join();
    }
}
