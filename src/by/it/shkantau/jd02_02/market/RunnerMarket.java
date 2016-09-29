package by.it.shkantau.jd02_02.market;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunnerMarket {

    private static final int CASH_MAX = 5;
    private final static List<Buyer> buyersList = new LinkedList<>();
    private final static List<Cashier> cashiers = new ArrayList<>();
    private static long startMils = System.currentTimeMillis();
    private static PriceList priceList = new PriceList();
    private static Double proceeds = 0.0;

    public static void main(String[] args) throws InterruptedException {

// generate Buyers
        generateBuyers((int) (5*Math.round( Math.random() + 5)));

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

//        System.out.println("MAIN IS FINISHED!!!!");

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

    synchronized static Double getProceeds() {
        return proceeds;
    }

    synchronized static void addProceeds(Double proceeds) {
        RunnerMarket.proceeds += proceeds;
    }
}
