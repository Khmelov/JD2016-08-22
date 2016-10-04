package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.controller.operation.*;
import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.view.*;
import java.util.LinkedHashMap;

public class Runner {
    public static LinkedHashMap<String, Var> storage = new LinkedHashMap<>();
    private static IPrintable printer;
    private static IReadable reader;
    private static String path;

    public static void main(String[] args) {
        init();
//        reader.deserializeMap(path); //загружаем сохраненные переменные в карту
        Parser parser = new Parser(reader);
        parser.run();
        printer.printMap(); //выводим карту на экран
//        printer.serializeMap(path); //сохраняем переменные из карты
    }

    public static void init() {
        path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/model/vars.txt";
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
    }
}