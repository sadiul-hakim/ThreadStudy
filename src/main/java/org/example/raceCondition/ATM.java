package org.example.raceCondition;

import java.util.concurrent.TimeUnit;

public class ATM {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        BankAccount account = new BankAccount(100);

        Thread depositingThread = new Thread(() -> {
//            for(int i = 0; i < 50 ; i++ ){
            account.deposit(100);
            sleep();
//            }
        });

        Thread withdrawingThread = new Thread(() -> {
//            for(int i = 0; i < 50 ; i++ ){
            account.withdraw(100);
            sleep();
//            }
        });

        depositingThread.start();
        withdrawingThread.start();

        try {
            depositingThread.join();
            withdrawingThread.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new AssertionError(ex);
        }

        System.out.println("---------------------------");
        System.out.println("Balance left: " + account.getCurrentBalance());

        long endTime = System.currentTimeMillis();

        System.out.println("Total Time : " + (endTime - startTime));
    }

    private static void sleep() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new AssertionError(ex);
        }
    }
}
