package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.model.report.BigReport;
import by.it.grechishnikov.matLab.model.report.Reporter;
import by.it.grechishnikov.matLab.model.report.SmallReport;
import by.it.grechishnikov.matLab.view.*;
import java.util.LinkedHashMap;

public class Runner {
    public static LinkedHashMap<String, Var> storage = new LinkedHashMap<>();
    public static Printer printer;
    private static IReadable reader;
    private static String path;
    private static Parser parser;
    public static Logger logger;
    private static Reporter reporter;

    public static void main(String[] args) {
        init(); //инициализация
        reader.deserializeMap(path); //загружаем сохраненные переменные в карту
        while (true) { //работаем до введенной строки end
            String line = reader.readValue();
            if(line.equals("end")) {
                break;
            }
            try {
                reporter.addRequest(line);
                reporter.addResult(parser.run(line));
            } catch (Exception e) {
                //если при парсинге была ошибка, то логгируем её
                printer.printLine("Ошибка");
                logger.log(e.getMessage());
            }
            reporter.printSmallReport();
        }
        printer.serializeMap(path); //сохраняем переменные из карты
        reporter.printBigReport();
    }

    public static void init() {
        reporter = new Reporter();
        reporter.setReports(new SmallReport(), new BigReport());
        path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/matlab/model/vars.txt";
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
        parser = new Parser();
        logger = Logger.getInstance();
    }
}