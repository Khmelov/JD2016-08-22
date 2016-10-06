package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.view.*;
import java.util.LinkedHashMap;

public class Runner {
    public static LinkedHashMap<String, Var> storage = new LinkedHashMap<>();
    private static IPrintable printer;
    private static IReadable reader;
    private static String path;
    private static Parser parser;

    public static void main(String[] args) {
        init(); //инициализация
        reader.deserializeMap(path); //загружаем сохраненные переменные в карту
        printer.printMap(); //выводим карту
        parser.run(reader.readValue());
        printer.serializeMap(path); //сохраняем переменные из карты
        printer.printMap(); //выводим карту
    }

    public static void init() {
        path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/model/vars.txt";
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
        parser = new Parser();
    }
}