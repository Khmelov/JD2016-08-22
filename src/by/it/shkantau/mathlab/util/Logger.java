package by.it.shkantau.mathlab.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    private static Logger loggerInstance;

    private String path ;
    private File logFile;

    private Logger(String path) {
        this.path = path;
        this.logFile = new File(path);
    }

    public static Logger getLogger(String path){
        if (loggerInstance == null){
            loggerInstance = new Logger(path);
        }
        return loggerInstance;
    }

    public void print(String string) {
        try (FileWriter fw = new FileWriter(logFile, true)){
            fw.write(new Date() +"\t" + string+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
