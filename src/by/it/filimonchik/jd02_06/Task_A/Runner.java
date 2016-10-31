package by.it.filimonchik.jd02_06.Task_A;

import java.io.IOException;

/**
 * Created by Raman.Filimonchyk on 29/10/2016.
 */
public class Runner {
    public static void main(String[] args) {

        try {
            throw new IOException( "File is already exist" );
        } catch (IOException e) {
            Singleton.getInstance().Error(e);
        }
    }
}