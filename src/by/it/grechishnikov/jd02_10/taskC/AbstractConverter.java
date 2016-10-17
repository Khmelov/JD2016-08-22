package by.it.grechishnikov.jd02_10.taskC;

import by.it.grechishnikov.jd02_10.Person;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class AbstractConverter {
    Person object;
    String text;
    private File path;
    File newPath;

    public AbstractConverter(String text) {
        this.text = text;
    }

    public AbstractConverter(File path) {
        this.path = path;
    }

    abstract String convertToString();

    abstract void convertToObject();

    public abstract void convertAndPrintResult();

    void checkText() {
        if(text == null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                text = "";
                while (reader.ready()) {
                    text += reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
