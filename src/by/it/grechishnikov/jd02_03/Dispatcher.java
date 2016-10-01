package by.it.grechishnikov.jd02_03;

import java.util.concurrent.*;

 class Dispatcher extends Thread {
    //Очередь - зал на 10 человек
    static ArrayBlockingQueue<Buyer> hall = new ArrayBlockingQueue<>(10);
    //пул кассиров
    private static ExecutorService threadPool = Executors.newFixedThreadPool(5);
     static volatile int finalCountClient;
    static volatile boolean endOfWork = false;

    public void run() {
        Printer.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        threadPool.submit(new Cashier("Мария"));
        threadPool.submit(new Cashier("Наталия"));
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

        Printer.println("***** Закрытие магазина! *****" +
                "\nОбслужено поситителей: " + Cashier.counter +
                "\nВыручка за день составила: $" + Printer.doubleToString(Cashier.getTotalProceeds()));
        endOfWork = true;
    }

     static void setFinalCountClient(int finalCountClient) {
         Dispatcher.finalCountClient = finalCountClient;
     }
 }