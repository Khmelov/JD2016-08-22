package by.it.grechishnikov.jd02_03;

import java.util.concurrent.ThreadLocalRandom;


class Runner {
    public static void main(String[] args) throws Exception {
        init(); //TODO в магазине могут быть от 5 до 40 поситителей. Всего обслужить 100
    }

    private static void init() {
        Printer.println("                                                  " +
                "         ***** Магазин открылся! Добро пожаловать! *****");

        int countBuyers = ThreadLocalRandom.current().nextInt(5, 40);
        Dispatcher.setFinalCountClient(countBuyers);
        Printer.println("                                           " +
                "                          Количество поситителей: " + countBuyers);
        Printer.println("           Мария                         Наталья                         Анна           " +
                "              Александра                         Зоя               Очер.   Выруч.");
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