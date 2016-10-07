package by.it.shkantau.jd02.jd02_02.market;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerMarket {

    private static final Lock   lock = new ReentrantLock();
    private static final int CASH_MAX = 5;
    private final static List<Buyer> buyersList = new LinkedList<>();
    private final static List<Cashier> cashiers = new ArrayList<>();
    private static long startMils = System.currentTimeMillis();
    private static PriceList priceList = new PriceList();
    private static Double proceeds = 0.0;

    public static void main(String[] args) throws InterruptedException {

        int threadCount = Thread.activeCount();

// generate Buyers
        generateBuyers((int) (Math.round(25.0*Math.random()) + 5));

// generate Cashiers and start all thread
        Cashier cashier;
        for (int i = 0; i < CASH_MAX; i++) {
            cashier = new Cashier(""+i);
            cashiers.add(cashier);
            new Thread(cashier).start();
        }

        for (Buyer buyer : buyersList) {
            new Thread(buyer).start();
        }


        while (threadCount < Thread.activeCount()){;}

        System.out.printf("Total proceed = %.2f\n", proceeds);
        System.out.println("Market is closed");

    }

    private  static void generateBuyers(int count){
        for (int i = 0; i < count; i++) {
            if  (i%4 == 0 && i != 0){
                buyersList.add(new Buyer(i, true, 1.5)); //pensioner
            }else{
                buyersList.add(new Buyer(i));
            }
        }
    }

    static List<Buyer> getBuyersList() {
        return buyersList;
    }

    static List<Cashier> getCashiers() {
        return cashiers;
    }

    static long getStartMils() {
        return startMils;
    }

    static PriceList getPriceList() {
        return priceList;
    }


    static void addProceeds(Double proceeds) {
        try{
            lock.lock();
            RunnerMarket.proceeds += proceeds;
        }finally {
            lock.unlock();
        }
    }
}
