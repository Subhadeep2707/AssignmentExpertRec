package com.expertrec.assignment;

import org.apache.commons.validator.routines.UrlValidator;

public class Utility {
    boolean validateUrl(String url){
        String[] schemes = {"http","https"}; // DEFAULT schemes = "http", "https", "ftp"
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(url);
    }
}
