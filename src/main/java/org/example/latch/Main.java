package org.example.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        CountDownLatch latch = new CountDownLatch(2);

        Developer developer1 = new Developer(latch);
        Developer developer2 = new Developer(latch);

        Tester tester = new Tester(latch);

        service.execute(developer1);
        service.execute(developer2);
        service.execute(tester);

        service.shutdown();
    }
}
