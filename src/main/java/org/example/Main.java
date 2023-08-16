package org.example;

import org.example.exception.CustomUncaughtExceptionHandler;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            System.out.println("Inside first thread:");
            sleep(TimeUnit.SECONDS,1);

            throw new RuntimeException("Testing the exception handler!");
        });
        thread1.setName("#Thread1");
        thread1.setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
        thread1.start();

    }

    static void sleep(TimeUnit timeUnit,int sec){
        try{
            Thread.sleep(timeUnit.toMillis(sec));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}