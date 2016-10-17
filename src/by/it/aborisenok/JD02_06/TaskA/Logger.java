package by.it.aborisenok.JD02_06.TaskA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class Logger {
    private static Logger instance = null;

    private Logger(){}

    public static Logger getInstance(){
        if (instance == null)
           instance = new Logger();
            return instance;
    }

    public void errorWriter(Exception e) {
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\JD02_06\\TaskA\\log.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(src, true))) {
            Date date = new Date(System.currentTimeMillis());
            String info = date + " : " + e.toString();
            writer.write(info);
            writer.newLine();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }
}
