package by.it.voronovich.JD01_15.Task_C;

import java.io.IOException;

import static by.it.voronovich.JD01_15.Task_C.Cd.*;
import static by.it.voronovich.JD01_15.Task_C.Dir.*;
import static by.it.voronovich.JD01_15.Task_C.Util.*;

/**
 * Метод запускает программу
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Run {

    public static void main(String[] args) throws IOException {
        String order;
        System.out.println(getPath());
        while (!"exit".equals((order = reader()).trim())) {
            if (readerC(order).equals("dir")) {
                dir();
            } else if (readerC(order).equals("cd")) {
                changeDir(order);
            } else {
                System.out.println("Повторите ввод...");
            }
        }
        System.out.println(getPath());
    }
}

