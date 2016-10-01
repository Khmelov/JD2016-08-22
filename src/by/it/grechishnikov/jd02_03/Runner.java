package by.it.grechishnikov.jd02_03;

import java.util.concurrent.ThreadLocalRandom;


class Runner {
    public static void main(String[] args) throws Exception {
        init();
    }

    private static void init() {
        Printer.println("***** Магазин открылся! Добро пожаловать! *****");

        int countBuyers = ThreadLocalRandom.current().nextInt(5, 40);
        Dispatcher.setFinalCountClient(countBuyers);
        Printer.println("Количество поситителей: " + countBuyers);
        for (int i = 0; i < countBuyers; i++) {
            Buyer b = new Buyer(i);
            if (i % 4 == 0) {
                b.setPensioner(true); //каждый 4ый - пенсионер
            }
            b.start();
        }

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.start();
    }
}