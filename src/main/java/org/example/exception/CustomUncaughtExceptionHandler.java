package org.example.exception;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        System.out.println("Inside Thread: "+thread.getName());
        System.out.println(throwable.getMessage());
    }
}
