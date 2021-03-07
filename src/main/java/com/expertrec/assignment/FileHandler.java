package com.expertrec.assignment;

import org.apache.commons.io.FilenameUtils;

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
            String extension = FilenameUtils.getExtension(file);
            if(!extension.equals("txt"))
                System.out.println("File provided is not a .txt file. It may or may not be readable.");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            try (FileWriter myWriter = new FileWriter(myObj)){
                myWriter.write(String.valueOf(responseString));
                System.out.println("Successfully wrote response body to the file.\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.\n");
            e.printStackTrace();
        }
    }
}
