package com.randomurl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {
    private static String outputFileName;
    private static String URL;
    private static int iterations;
    private static int maxRandomId;
    private static String uniqueURL;
    public Random random;
    public static PrintWriter printLine;
    public static FileWriter write;

    public static void main(String[] args) throws IOException {
        if ((args == null) || (args.length == 0))
        {
            System.out.println("Correct use is java -jar jarname URL(s) Output File Name Number of URLs Max Integer to Append");
            System.exit(0);
        }
        URL = args[0];
        outputFileName = args[1];
        iterations = Integer.parseInt(args[2]);
        maxRandomId = Integer.parseInt(args[3]);
        Random random = new Random();
        FileWriter write = new FileWriter(outputFileName, false);
        PrintWriter printLine = new PrintWriter(write);
        createURLSFile(random, printLine);
        printLine.close();
    }

    private static String checkURLFormat(String arg) {
        //Starts with either http or https
        String[] scheme = {"http://","https://"};
        if (!arg.contains(scheme[0])){
            if (!arg.contains(scheme[1])){
                System.out.println(arg + " does not begin with http:// or https://, correct and try again");
                System.exit(0);
            }
        }
        return arg;
    }

    private static void createURLSFile(Random random, PrintWriter printLine) {
        for(int i = 0; i < iterations; ++i) {
            String eventId = Integer.toString(random.nextInt(maxRandomId));
            int noOfURLs = countURLs(URL);
            String uniqueURL = randomURL(URL, noOfURLs) + eventId;
            System.out.println(uniqueURL);
            printLine.printf("%s%n", uniqueURL);
        }
    }

    private static String randomURL(String URL, int i) {
        String[] result = URL.split("\\s");
        for (int j = 0; j < result.length; j++){
            checkURLFormat(result[j]);
        }
        Random number = new Random();
        return result[number.nextInt(i)];
    }

    private static int countURLs(String URL) {
        String[] result = URL.split("\\s");
        return result.length;
    }
}