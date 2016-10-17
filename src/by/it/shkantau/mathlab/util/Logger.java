package by.it.shkantau.mathlab.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger loggerInstance;
    private static final DateFormat df = new SimpleDateFormat("MM.dd.yyyy HH:mm:ss");

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
            fw.write(df.format(new Date()) +"\t" + string+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
