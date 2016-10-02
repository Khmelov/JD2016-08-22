package by.it.snegurskiy.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
class QueueBuyer {
    static final Deque<Buyer> buyers = new ArrayDeque<Buyer>() {


        @Override
        public void addLast(Buyer buyer) {
            synchronized (buyers) {
                super.addLast(buyer);
                if (Runner0202.countCashiers < 5 && QueueBuyer.buyers.size()>Runner0202.countCashiers*2) {
                    Cashier cashier = new Cashier(++Runner0202.countCashiers);
                    new Thread(cashier).start();
                }
            }
        }
    };

}
