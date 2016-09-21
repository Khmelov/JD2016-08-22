package by.it.grechishnikov.jd01_13.matLab.controller;


public class ReaderFromConsoleImplIReadable extends Reader {

    @Override
    public String readValue() {
        System.out.println("Введите уравнение: ");
        return readStringFromConsole();
    }
}