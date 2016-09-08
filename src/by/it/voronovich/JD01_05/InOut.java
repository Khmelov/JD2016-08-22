package by.it.voronovich.JD01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс осуществляет ввод с клавиатуры и вывод результата
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class InOut {

    protected static double getX() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double b = Double.parseDouble(reader.readLine());
        return b;
    }
}
