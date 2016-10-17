package by.it.aborisenok.JD02_06.TaskA;

import com.sun.javafx.geom.IllegalPathStateException;

import java.io.IOException;
import java.util.Date;
import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        try {
            throw new NullPointerException();
        } catch (Exception e){
            Logger.getInstance().errorWriter(e);
        }
            Thread.sleep(500);
        try {
            throw new IllegalPathStateException();
        } catch (Exception e){
            Logger.getInstance().errorWriter(e);
        }
        Thread.sleep(500);
        try {
            throw new IOException();
        } catch (Exception e){
            Logger.getInstance().errorWriter(e);
        }
    }
}
