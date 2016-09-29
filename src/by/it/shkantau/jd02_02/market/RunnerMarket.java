package by.it.shkantau.jd02_02.market;

import java.util.LinkedList;
import java.util.List;

public class RunnerMarket {

    private static final int CASH_MAX = 5;
    private final static List<Buyer> buyersList = new LinkedList<>();
    private final static List<Cashier> cashiers = new LinkedList<>();
    private static long startMils = System.currentTimeMillis();
    private static PriceList priceList = new PriceList();;

    public static void main(String[] args) throws InterruptedException {

// generate Buyers
        generateBuyers((int) (5*Math.round( Math.random() + 5)));

// generate Cashiers
        Cashier cashier;
        for (int i = 0; i < CASH_MAX; i++) {
            cashier = new Cashier(""+i);
            cashiers.add(cashier);
            new Thread(cashier).start();
        }

        for (Buyer buyer : buyersList) {
            new Thread(buyer).start();
        }

    }

    private  static void generateBuyers(int count){
        for (int i = 0; i < count; i++) {
            buyersList.add(new Buyer(i));
        }
    }

    public static List<Buyer> getBuyersList() {
        return buyersList;
    }

    public static List<Cashier> getCashiers() {
        return cashiers;
    }

    public static long getStartMils() {
        return startMils;
    }

    public static void setStartMils(long startMils) {
        RunnerMarket.startMils = startMils;
    }

    public static PriceList getPriceList() {
        return priceList;
    }

    public static void setPriceList(PriceList priceList) {
        RunnerMarket.priceList = priceList;
    }
}
