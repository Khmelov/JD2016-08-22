package by.it.grechishnikov.jd01_13.matLab.controller;


import java.io.FileReader;

public class ReaderFromStreamImplIReadable extends Reader {
    private FileReader from;


    public ReaderFromStreamImplIReadable(FileReader from) {
        this.from = from;
    }

    @Override
    public String readValue() {
        String result = "";
        try {
            while (from.ready()) {
                result += from.read();
            }
            return result;
        } catch (Exception e) {
            System.out.println("Ошибка.");
        }
        return null;
    }
}