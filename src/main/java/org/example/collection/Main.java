package org.example.collection;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        IntStream.rangeClosed(1,100).forEach(list::add);

        Thread summingThread = new Thread(()->{
            int sum = Util.getSum(list);
            System.out.println(sum);
        });

        Thread remover = new Thread(()->{
            IntStream.rangeClosed(1,10).forEach(item-> Util.removeLastItem(list));
        });

        summingThread.start();
        remover.start();

        summingThread.join();
        remover.join();

        System.out.println(Util.getSum(list));

        System.out.println(list.size());
    }
}