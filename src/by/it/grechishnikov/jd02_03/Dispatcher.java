package by.it.grechishnikov.jd02_03;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher extends Thread {
    //Очередь - зал на 10 человек
    static ArrayBlockingQueue<Buyer> hall = new ArrayBlockingQueue<>(10);
    //пул кассиров
    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);
    private static volatile int finalCountClient;
    static volatile boolean endOfWork = false;
    static ArrayBlockingQueue<Buyer> store = new ArrayBlockingQueue<>(40);
    private static String tab = "                                                                   ";

    public void run() {
        threadPool.submit(new Cashier("Мария"));
        threadPool.submit(new Cashier("Наталья"));
        threadPool.submit(new Cashier("Анна"));
        threadPool.submit(new Cashier("Александра"));
        threadPool.submit(new Cashier("Зоя"));
        threadPool.shutdown();

        while (finalCountClient != Cashier.counter.intValue()) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Printer.println(tab + "***** Закрытие магазина! *****" +
                "\n" + tab + "Обслужено поситителей: " + Cashier.counter +
                "\n" + tab + "Выручка за день составила: $" + Printer.doubleToString(Cashier.getTotalProceeds()));
        endOfWork = true;
    }

    static void setFinalCountClient(int finalCountClient) {
        Dispatcher.finalCountClient = finalCountClient;
    }
}