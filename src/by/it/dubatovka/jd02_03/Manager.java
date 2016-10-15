package by.it.dubatovka.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

 class Manager {
    protected static int countBuyers = 0;
    protected static int limitBuyers = 100;
    protected static int countCashier = 0;
    protected static int limitCashier = 5;

    static boolean limitBuyers() {
        return countBuyers >= limitBuyers;
    }

    static AtomicInteger countCompleteBuyers = new AtomicInteger(0);

    static boolean finish() {
        return (countCompleteBuyers.get() >= limitBuyers);
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
