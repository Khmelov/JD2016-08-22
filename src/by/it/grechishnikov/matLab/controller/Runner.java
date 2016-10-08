package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.view.*;
import java.util.LinkedHashMap;

public class Runner {
    public static LinkedHashMap<String, Var> storage = new LinkedHashMap<>();
    private static Printer printer;
    private static IReadable reader;
    private static String path;
    private static Parser parser;
    public static Logger logger;

    public static void main(String[] args) {
        init(); //инициализация
        reader.deserializeMap(path); //загружаем сохраненные переменные в карту
        while (true) {
            printer.printMap(); //выводим карту
            String line = reader.readValue();
            if(line.equals("end")) {
                break;
            }
            try {
                parser.run(line);
            } catch (Exception e) {
                //если при парсинге была ошибка, то логгируем её
                printer.printLine("Ошибка");
                logger.log(e.getMessage());
            }
        }
        printer.serializeMap(path); //сохраняем переменные из карты
    }

    public static void init() {
        path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/model/vars.txt";
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
        parser = new Parser();
        logger = Logger.getInstance();
    }
}