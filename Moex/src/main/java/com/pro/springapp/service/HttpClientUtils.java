package com.pro.springapp.service;

import org.springframework.lang.NonNull;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


public class HttpClientUtils {

    public String httpGet(@NonNull String url) {

        String jsonString = "";

        try {
            HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(30)).build();
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonString = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}