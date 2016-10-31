package by.it.filimonchik.jd02_06.Task_B;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Raman.Filimonchyk on 30/10/2016.
 */
public class Logger {
    private static Logger inst;

    private Logger() {
    }

    public static Logger getInstance() {
        if (inst == null)
            inst = new Logger();
        return inst;
    }
    public void Error(Exception error) {
        String src = System.getProperty( "user.dir" ) + "/src/by/it/filimonchik/";
        String file = src + "jd02_06/Task_B/Log.txt";
        try (PrintWriter printer = new PrintWriter( new FileWriter( file ) )) {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat();
            printer.println(format.format(date));
            printer.write(error.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
