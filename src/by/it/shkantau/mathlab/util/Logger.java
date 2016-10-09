package by.it.shkantau.mathlab.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Logger {

    private static Logger loggerInctance;

    private String path = System.getProperty("user.dir") + "\\src\\by\\it\\shkantau\\mathlab\\mathLab.log";
    private File logFile = new File(path);

    private Logger() {
    }

    public static Logger getLogger(){
        if (loggerInctance == null){
            loggerInctance = new Logger();
        }
        return loggerInctance;
    }

    void print(String string) {
        try (FileWriter fw = new FileWriter(logFile)){
            fw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
