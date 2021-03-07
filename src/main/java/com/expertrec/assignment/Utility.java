package com.expertrec.assignment;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.HttpResponse;

public class Utility {
    boolean validateUrl(String url){
        String[] schemes = {"http","https"}; // DEFAULT schemes = "http", "https", "ftp"
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(url);
    }

    boolean checkIfHTMLContent(HttpResponse response) {
        String server = response.getFirstHeader("Content-Type").getValue();
        return server.contains("text/html");
    }
}
