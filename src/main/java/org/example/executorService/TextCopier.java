package org.example.executorService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

public class TextCopier implements Callable<String> {

    private final String url;

    public TextCopier(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(new URI(url))
                .build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());

        return send.body();
    }
}
