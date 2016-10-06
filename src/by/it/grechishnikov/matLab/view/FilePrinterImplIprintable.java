package by.it.grechishnikov.matLab.view;


import by.it.grechishnikov.matLab.model.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

import static by.it.grechishnikov.matLab.controller.Runner.storage;

public class FilePrinterImplIprintable extends Printer {
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
