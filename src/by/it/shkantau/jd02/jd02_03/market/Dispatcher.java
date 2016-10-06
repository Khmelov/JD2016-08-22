package by.it.shkantau.jd02.jd02_03.market;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


 class Dispatcher {
    private final static int buyersPlan = 30;
    final static AtomicInteger buyerCounter = new AtomicInteger(0);
    final static AtomicInteger cashiersCounter = new AtomicInteger(RunnerMarket.CASH_MAX);
    final static AtomicBoolean cashesIsWorked = new AtomicBoolean(false);


    static boolean planComplete(){
        return buyerCounter.get() >= buyersPlan;
    }

    static boolean isFinished(){
        return cashiersCounter.get() == 0;
    }

    static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
