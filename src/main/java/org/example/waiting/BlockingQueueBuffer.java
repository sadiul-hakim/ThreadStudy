package org.example.waiting;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueBuffer {
    private final BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

    public void addItem(int item) {
        try {
            blockingQueue.put(item);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            throw new AssertionError(ex);
        }
    }

    public void getItem() throws InterruptedException {
        try {
            Integer take = blockingQueue.take();
            System.out.println("Consumed: " + take);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            throw new AssertionError(ex);
        }
    }
}
