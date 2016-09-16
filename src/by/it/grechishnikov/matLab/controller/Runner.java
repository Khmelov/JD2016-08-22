package by.it.grechishnikov.matLab.controller;

import by.it.grechishnikov.matLab.model.*;
import by.it.grechishnikov.matLab.view.*;

import java.util.HashMap;

public class Runner {
    public static HashMap<String, Var> storage = new HashMap<>();

    public static void main(String[] args) throws Exception {
        IPrintable printer = new ConsolePrinterImplIprintable();
        IReadable reader = new ReaderFromConsoleImplIReadable();

        double[][] mat = {{1,2}, {8,3}};
        Matrix m1 = new Matrix("m", mat);
        m1.assign();
        Vector v1 = new Vector("v", 2,3,4);
        Scalar s1 = new Scalar("s", -4);
        Var v = s1.add(s1);
        v.assign();

        printer.printMap();
    }
}