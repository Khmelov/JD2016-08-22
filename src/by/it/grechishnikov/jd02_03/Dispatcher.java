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

        endOfWork = true;
        Printer.println("***** Закрытие магазина! *****");
        Printer.println("Обслужено поситителей: " + Cashier.counter);
        Printer.print("Выручка за день составила: ");
        Printer.printDouble(Cashier.getTotalProceeds());
    }

     public static void setFinalCountClient(int finalCountClient) {
         Dispatcher.finalCountClient = finalCountClient;
     }
 }