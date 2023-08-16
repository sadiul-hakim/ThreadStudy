package org.example.executorService;

import java.util.concurrent.TimeUnit;

public class Task {
    public void doSomething(int integer){
        System.out.println("I am "+integer+" working");
        for(int i=0;i<=1_000_000;i++){

        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
