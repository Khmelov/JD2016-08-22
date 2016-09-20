package by.it.grechishnikov.jd01_13.matLab.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;

abstract class Reader implements IReadable {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    static String readStringFromConsole() {
        String result = "";
        try {
            result = consoleReader.readLine();
        } catch (Exception e) {
            System.out.println("Ошибка.");
        }
        return result;
    }
}
