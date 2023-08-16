package org.example.executorService;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        final String url = "https://6367846d5edb75000957c215--funny-caramel-8bfd6c.netlify.app/";

        Future<String> submit = service.submit(new TextCopier(url));

        String response = submit.get();

        System.out.println(response);

    }
}
