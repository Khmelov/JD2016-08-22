package by.it.grechishnikov.matLab.controller;


import java.io.*;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;
    private static BufferedWriter writer;

    private Logger() {
        try {
            writer = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/controller/log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        try {
            Date date = new Date();
            DateFormat timeFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
            writer.append(timeFormat.format(date) + " : " + message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
