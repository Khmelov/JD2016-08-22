package by.it.grechishnikov.matLab.view;

import by.it.grechishnikov.matLab.controller.Runner;
import by.it.grechishnikov.matLab.model.*;

import java.io.*;
import java.util.Map;

/**
 * Created by Evgeniy on 27.09.16.
 */
public abstract class Printer implements IPrintable {
    public void serializeMap(String path) {
        System.out.println("Сериализуем карту");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            for(Map.Entry<String, Var> pair : Runner.storage.entrySet()) {
                out.writeObject(pair.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
    }
}
