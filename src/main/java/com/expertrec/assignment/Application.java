package com.expertrec.assignment;

import org.apache.http.HttpResponse;

import java.io.IOException;

public class Application {

    private String file;
    private String url;
    Utility util;
    ResponseHandler responseHandler;

    Application(String url, String file){
        this.url = url;
        this.file = file;
        util = new Utility();
    }

    void handler() throws IOException {
        if(util.validateUrl(url)) {
            responseHandler = new ResponseHandler(url);
        }
        else{
            System.out.println("The url entered in not valid!");
            System.exit(1);
        }

        HttpResponse response = responseHandler.callURL();
        //System.out.print(response);

        int statusCode = responseHandler.getStatusCode(response);
        System.out.println("Status code = " + statusCode);
        System.out.println("\n");

    }
}
