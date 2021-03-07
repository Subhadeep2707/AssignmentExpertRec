package com.expertrec.assignment;

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

    void handler(){
        if(util.validateUrl(url)) {
            responseHandler = new ResponseHandler(url);
        }
        else{
            System.out.println("The url entered in not valid!");
            System.exit(1);
        }
    }
}
