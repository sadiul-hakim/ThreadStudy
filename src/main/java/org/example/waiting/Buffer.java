package org.example.waiting;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Long> list = new LinkedList<>();
    private final int SIZE = 10;

    public synchronized void addItem(long item){
        while (list.size() == SIZE){
            System.out.println("Size full can not add!");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        System.out.println("Adding item: "+item);
        list.add(item);
        notifyAll();
    }

    public synchronized void getItem(){
        while (list.isEmpty()){
            System.out.println("Queue is empty can not get!");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

        long item = list.poll();
        System.out.println("Consumed Item : "+item);
        notifyAll();
    }
}
