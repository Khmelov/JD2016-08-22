package by.it.voronovich.JD01_12.Task_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс осуществлят ввод с клавиатуры
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Util {

    public static int getN() throws IOException {
        System.out.println("Введите количество студентов в списке: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        return n1;
    }
}
