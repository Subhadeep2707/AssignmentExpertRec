package com.expertrec.assignment;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;

public class Application {

    private String file;
    private String url;
    Utility util;
    ResponseHandler responseHandler;
    FileHandler fileHandler;

    Application(String url, String file){
        this.url = url;
        this.file = file;
        util = new Utility();
    }

    int handler() throws IOException {
        if(util.validateUrl(url)) {
            responseHandler = new ResponseHandler(url);
        }
        else{
            System.out.println("The url entered in not valid!");
            System.exit(1);
        }

        HttpResponse response = responseHandler.callURL();
        //System.out.println(response);
        if(response == null){
            System.exit(1);
        }

        int statusCode = responseHandler.getStatusCode(response);
        System.out.println("Status code = " + statusCode);
        System.out.println("\n");

        StringBuilder responseString = responseHandler.getResponseBody(response);
        fileHandler = new FileHandler(file);
        fileHandler.writeToFile(responseString);
        //System.out.println(responseString);

        System.out.println("Headers: \n");

        HashMap<String, String> headerList = responseHandler.getHeaders(response);
        headerList.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println("\n");

        if(util.checkIfHTMLContent(response)){
            String title = responseHandler.getTitle(responseString);
            if(title.isEmpty())
                System.out.println("No title present");
            else
                System.out.println("Title = " + title);
        }
        else{
            System.out.println("Title not extracted as the content-type is not html.");
        }

        if(statusCode == 200)
            return 0;
        else
            return statusCode;
    }
}
