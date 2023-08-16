package org.example.deadlock;

public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void running(){
        synchronized (lock1){
            System.out.println("Acquired lock1");

            synchronized (lock2){
                System.out.println("Acquired lock2");

                System.out.println("Running.......");

                System.out.println("Release lock2");
            }

            System.out.println("Release lock1");
        }
    }

    public void walking(){
        synchronized (lock2){
            System.out.println("Acquired lock2");

            synchronized (lock1){
                System.out.println("Acquired lock1");

                System.out.println("Running.......");

                System.out.println("Release lock1");
            }

            System.out.println("Release lock2");
        }
    }
}
