package com.expertrec.assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String file;
    public FileHandler(String file) {
        this.file = file;
    }
    void writeToFile(StringBuilder  responseString) {
        try {
            File myObj = new File(file);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            try (FileWriter myWriter = new FileWriter(myObj)){
                myWriter.write(String.valueOf(responseString));
                System.out.println("Successfully wrote to the file.\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.\n");
            e.printStackTrace();
        }
    }
}
