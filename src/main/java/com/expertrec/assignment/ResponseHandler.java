package com.expertrec.assignment;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class ResponseHandler {
    private String url;

    ResponseHandler(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    HttpResponse callURL() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(getUrl());
        return client.execute(request);
    }
}
