package by.it.grechishnikov.jd01_13.matLab.view;


import by.it.grechishnikov.jd01_13.matLab.model.Matrix;
import by.it.grechishnikov.jd01_13.matLab.model.Var;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import static by.it.grechishnikov.jd01_13.matLab.controller.Runner.storage;

public class FilePrinterImplIprintable implements IPrintable {
    private File path;

    public FilePrinterImplIprintable(File path) {
        this.path = path;
    }

    @Override
    public void print(Var var) {
        try(FileWriter writer = new FileWriter(path)) {
            for(char c : var.toString().toCharArray()) {
                writer.write(c);
            }
            writer.flush();
        } catch (Exception e) {
            System.out.println("Ошибка.");
        }
    }

    @Override
    public void printMap() {
        try(FileWriter writer = new FileWriter(path)) {
            for(Map.Entry<String, Var> pair : storage.entrySet()) {
                String s = pair.getKey() + " : " + (pair.getValue() instanceof Matrix ? "\n" + pair.getValue().valueToString() : pair.getValue().valueToString());
                for(char c : s.toCharArray()) {
                    writer.write(c);
                }
            }
            writer.flush();
        } catch (Exception e) {
            System.out.println("Ошибка.");
        }
    }
}
