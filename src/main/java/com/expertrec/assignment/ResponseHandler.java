package com.expertrec.assignment;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.rmi.UnknownHostException;
import java.util.HashMap;

public class ResponseHandler {
    private String url;

    ResponseHandler(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    HttpResponse callURL() {
        HttpResponse res = null;
        try{
            HttpClient client = HttpClientBuilder.create()
                    .setDefaultRequestConfig(RequestConfig.custom()
                            .setCookieSpec(CookieSpecs.STANDARD).build()).build();
            HttpGet request = new HttpGet(getUrl());
            res =  client.execute(request);
        }catch(UnknownHostException e){
            System.out.println("Cannot connect to host.");
        }catch(IOException e){
            System.out.println("I/O error.");
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    int getStatusCode(HttpResponse response) {
        return response.getStatusLine().getStatusCode();
    }

    StringBuilder getResponseBody(HttpResponse response) throws IOException {
        String line = null;
        StringBuilder  responseString = new StringBuilder ();
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        while ((line = in.readLine()) != null) {
            String decoded = new String(line.getBytes(), StandardCharsets.UTF_8);
            responseString.append("\n").append(decoded);
        }
        return responseString;
    }

    HashMap<String, String> getHeaders(HttpResponse response) {
        Header[] headers = response.getAllHeaders();
        HashMap<String, String> headerList = new HashMap<>();
        for (Header header : headers) {
            //System.out.println("Key : " + header.getName() + " ,Value : " + header.getValue());
            headerList.put(header.getName(), header.getValue());
        }
        return headerList;
    }

    String getTitle(StringBuilder  tmp) {
        Document doc = Jsoup.parse(String.valueOf(tmp));
        return doc.title();
    }

}
