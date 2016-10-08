package by.it.grechishnikov.matLab.controller;


import java.io.*;
import by.it.grechishnikov.matLab.model.*;

abstract class Reader implements IReadable {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    static String readStringFromConsole() {
        String result = "";
        try {
            result = consoleReader.readLine();
        } catch (Exception e) {
            System.out.println("Ошибка.");
            Runner.logger.log(e.getMessage());
        }
        return result;
    }

    public void deserializeMap(String path) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            Object o;
            while((o = in.readObject()) != null) {
                Var v = (Var) o;
                v.assign();
            }
        } catch (Exception e) {
            System.out.println("Считывание из файла завершено");
        }
    }
}
