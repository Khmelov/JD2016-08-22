package by.it.shkantau.jd02_03.market;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnerMarket {

    private static final Lock   lock = new ReentrantLock();
    private static Double proceeds = 0.0;
    static final int CASH_MAX = 5;
    public static final int BUYERS_MAX = 5;

    private static ExecutorService cashesExecutor = Executors.newFixedThreadPool(CASH_MAX);
    private final static CopyOnWriteArrayList <Buyer> buyersList = new CopyOnWriteArrayList<>();
    private final static PriceList priceList = new PriceList();

    public static void main(String[] args) throws InterruptedException {


        openMarket(CASH_MAX);

        while (!Dispatcher.planComplete()){

            generateBuyers((int) (Math.round(10.0*Math.random()) + 5));

            Dispatcher.sleep(1000);
        }

        while (!Dispatcher.isFinished());

        closeMarket();

    }



    /**
     * Generate Cashiers and start all thread in a poll
     * @param cashiers number of cashes
     */
    private static  void openMarket(int cashiers){
        Dispatcher.cashesIsWorked.set(true);
        for (int i = 0; i < CASH_MAX; i++) {
            cashesExecutor.execute(new Cashier(""+i));
        }
    }

    /**
     * Close a market
     */
    private static void closeMarket(){
        cashesExecutor.shutdown();
        System.out.printf("Total proceed = %.2f\n", proceeds);
        System.out.println("Market is closed");
    }

    /**
     * Generate and start buyers Threads. Update buyerCounter
     * @param count buyers count
     */
    private  static void generateBuyers(int count){
        Buyer buyer;
        int buyersListSize = buyersList.size();
        for (int i = buyersListSize+1 ; i <= buyersListSize+count; i++) {
            if  (i%4 == 0 && i != 0){
                buyer = new Buyer(i, true, 1.5);
                buyersList.add(buyer); //pensioner
            }else{
                buyer = new Buyer(i);
                buyersList.add(buyer);
            }
            new Thread(buyer).start();
        }
        Dispatcher.buyerCounter.getAndAdd(count);
    }

    static List<Buyer> getBuyersList() {return buyersList;
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
