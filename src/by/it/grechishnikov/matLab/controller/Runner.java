package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.controller.operation.*;
import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.view.*;
import java.util.LinkedHashMap;

public class Runner {
    public static LinkedHashMap<String, Var> storage = new LinkedHashMap<>();
    private static IPrintable printer;
    private static IReadable reader;
    private static Operation operation;

    public static void main(String[] args) throws Exception {
        init();
        test();
    }

    public static void init() {
        printer = new ConsolePrinterImplIprintable();
        reader = new ReaderFromConsoleImplIReadable();
        operation = new Operation();
    }

    public static void test() throws Exception {
        Scalar s = new Scalar(4);
        Vector v = new Vector(1,2,3);
        double[][] arr = {{1,2,3}, {4,5,6}, {7,8,9}};
        Matrix m = new Matrix(arr);

        operation.add("1", s, s).assign();
        operation.add("2", s, v).assign();
        operation.add("3", s, m).assign();
        operation.add("4", v, s).assign();
        operation.add("5", v, v).assign();
        operation.add("6", v, m).assign();
        operation.add("7", m, s).assign();
        operation.add("8", m, v).assign();
        operation.add("9", m, m).assign();

        printer.printMap();
        storage.clear();

        operation.sub("10", s, s).assign();
        operation.sub("11", s, v).assign();
        operation.sub("12", s, m).assign();
        operation.sub("13", v, s).assign();
        operation.sub("14", v, v).assign();
        operation.sub("15", v, m).assign();
        operation.sub("16", m, s).assign();
        operation.sub("17", m, v).assign();
        operation.sub("18", m, m).assign();

        printer.printMap();
        storage.clear();

        operation.mul("19", s, s).assign();
        operation.mul("20", s, v).assign();
        operation.mul("21", s, m).assign();
        operation.mul("22", v, s).assign();
        operation.mul("23", v, v).assign();
        operation.mul("24", v, m).assign();
        operation.mul("25", m, s).assign();
        operation.mul("26", m, v).assign();
        operation.mul("27", m, m).assign();

        printer.printMap();
        storage.clear();

        operation.div("28", s, s).assign();
        operation.div("29", s, v).assign();
        operation.div("30", s, m).assign();
        operation.div("31", v, s).assign();
        operation.div("32", v, v).assign();
        operation.div("33", v, m).assign();
        operation.div("34", m, s).assign();
        operation.div("35", m, v).assign();
        operation.div("36", m, m).assign();

        printer.printMap();
        storage.clear();
    }
}