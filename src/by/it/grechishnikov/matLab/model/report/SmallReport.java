package by.it.grechishnikov.matLab.model.report;


import by.it.grechishnikov.matLab.controller.Runner;

public class SmallReport extends ReportBuilder {

    @Override
    public void printOperation() {
        Runner.printer.printLine("Операция : Результат\n" + request + " : " + result);
    }
}