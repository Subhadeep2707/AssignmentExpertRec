package com.expertrec.assignment;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Application application;
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("h", "help", false, "Show this help");
        options.addOption("u", "url", true, "Url Parameter");
        options.addOption("f", "file", true, "File Parameter");
        String urlArg = null;
        String fileArg = null;
        try {
            CommandLine commandLine = parser.parse(options, args);
            urlArg = commandLine.getOptionValue("u");
            fileArg = commandLine.getOptionValue("f");
            //System.out.println(urlArg);
            //System.out.println(fileArg);

            if ((urlArg == null) && (fileArg == null)){
                if (commandLine.hasOption("h")) {
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("CommandLineParameters", options);
                }
                else {
                    System.out.println("Url and File Parameters missing. Enter -h as argument for help.");
                }
                System.exit(1);
            }
            else if (urlArg == null) {
                System.out.println("Url parameter missing. Enter -h as argument for help.");
                System.exit(1);
            } else if (fileArg == null){
                System.out.println("File parameter missing. Enter -h as argument for help.");
                System.exit(1);
            }

        } catch (ParseException e){
            e.printStackTrace();
        } finally {
            application = new Application(urlArg, fileArg);
            application.handler();
        }
    }
}
