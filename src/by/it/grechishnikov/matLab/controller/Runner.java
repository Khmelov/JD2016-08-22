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
    private static Parser parser;

    public static void main(String[] args) {
        init();
//        reader.deserializeMap(path); //загружаем сохраненные переменные в карту
//        printer.printMap(); //выводим карту
//        parser.run(reader.readValue());
        test();
//        printer.serializeMap(path); //сохраняем переменные из карты
        printer.printMap(); //выводим карту
    }

    private static void test() {
        parser.run("A=2+5.3");
        parser.run("B=A*3.5");
        parser.run("B1=B-0.55");
        parser.run("B2=A/2");
        parser.run("C=B+(A*2)");
        parser.run("D=((C-0.15)-20)/(7-5)");
//        parser.run("E={2,3}*3");
    }

    public static void init() {
        path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/model/vars.txt";
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
        parser = new Parser(reader);
    }
}