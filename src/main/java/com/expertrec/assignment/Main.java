package com.expertrec.assignment;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String urlArg = "https://www.google.com";
        String fileArg = "google.txt";

        Application application = new Application(urlArg, fileArg);
        application.handler();
    }
}
