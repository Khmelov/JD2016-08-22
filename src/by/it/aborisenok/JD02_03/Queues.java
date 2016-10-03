package by.it.aborisenok.JD02_03;


import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Лёша on 28.09.2016.
 */
public class Queues {

    private final static ConcurrentLinkedQueue queueBuyers = new ConcurrentLinkedQueue();


    public static boolean add(Buyer buyer) {

        if (Runner.countCashiers < 5 && Queues.queueBuyers.size()>Runner.countCashiers*2) {
            Cashier cashier = new Cashier(++Runner.countCashiers);
            new Thread(cashier).start();
        }
        return queueBuyers.add(buyer);
    }


    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }

    public static int size(){
        return queueBuyers.size();
    }
}
