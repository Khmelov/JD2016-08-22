package by.it.grechishnikov.matLab.controller;


import java.io.*;

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
