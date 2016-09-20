package by.it.grechishnikov.jd01_13.matLab.view;

import by.it.grechishnikov.jd01_13.matLab.model.Matrix;
import by.it.grechishnikov.jd01_13.matLab.model.Var;

import java.util.Map;

import static by.it.grechishnikov.jd01_13.matLab.controller.Runner.storage;


public class ConsolePrinterImplIprintable implements IPrintable {
    public void print(Var var) {
        System.out.println(var);
    }

    @Override
    public void printMap() {
        for(Map.Entry<String, Var> pair : storage.entrySet()) {
            String s = pair.getValue() instanceof Matrix ? "\n" + pair.getValue().valueToString() : pair.getValue().valueToString() ;
            System.out.println(pair.getKey() + " : " + s);
        }
    }
}
