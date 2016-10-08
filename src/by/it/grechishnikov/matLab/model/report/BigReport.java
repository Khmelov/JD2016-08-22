package by.it.grechishnikov.matLab.model.report;


import by.it.grechishnikov.matLab.controller.Runner;

import java.text.DateFormat;
import java.util.*;

public class BigReport extends ReportBuilder {
    String head;//заголовок
    Date start;//дата начала
    Map<String, String> operations;//запросы и результаты

    public BigReport() {
        head = "Завершение программы...";
        start = new Date();
        operations = new LinkedHashMap<>();
    }

    @Override
    public void setResult(String result) {
        super.setResult(result);
        operations.put(request, result);
    }

    @Override
    public void printOperation() {
        Runner.printer.printLine(head);
        printTime();
        Runner.printer.printLine("Выполненные операции : Результаты выполнения");
        for (Map.Entry<String,String> pair: operations.entrySet()) {
            Runner.printer.printLine(pair.getKey() + " : " + pair.getValue());
        }
    }

    private void printTime() {
        DateFormat format = DateFormat.getDateTimeInstance();
        Runner.printer.printLine("Дата старта программы:\n" + format.format(start));
        Date end = new Date();
        Runner.printer.printLine("Дата завершения программы:\n" + format.format(end));
    }
}
