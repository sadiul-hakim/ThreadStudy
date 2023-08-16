package org.example;

public class ThreadLocalTest {
    private final ThreadLocal<Integer> number = new ThreadLocal<>();

    public void setNumber() {
        number.set((number.get() == null ? 0 : number.get()) + 3);
    }

    public int getNumber() {
        return number.get();
    }

    private static void setRandomNumber(ThreadLocalTest test) {
        test.setNumber();

        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println(test.getNumber());
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();

        Thread thread1 = new Thread(() -> {
            setRandomNumber(test);
        });
        thread1.setName("Thread1");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            setRandomNumber(test);
        });
        thread2.setName("Thread2");
        thread2.start();
    }
}
