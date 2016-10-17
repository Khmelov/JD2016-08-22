package by.it.aborisenok.matLab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Лёша on 09.09.2016.
 */
public class Logger {
    private static Logger instance = null;

    private Logger(){}

    public static Logger getInstance(){
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    public void errorPrinter(Exception e){
        System.out.println(e.toString() + " : " + e.getMessage());
        errorWriter(e);
    }

    public void errorWriter(Exception e) {
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\matLab\\log.txt";
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
