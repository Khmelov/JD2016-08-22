package by.it.filimonchik.jd02_06.Task_A;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Raman.Filimonchyk on 29/10/2016.
 */
public class Singleton {

    private static Singleton inst;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (inst == null)
            inst = new Singleton();
        return inst;
    }
    public void Error(Exception error) {
        String src = System.getProperty( "user.dir" ) + "/src/by/it/filimonchik/";
        String file = src + "jd02_06/Task_A/Log.txt";
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