package by.it.dubatovka.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class Queues {
    static final Deque<Buyer> buyers = new ArrayDeque<Buyer>() {

        @Override
        public void addLast(Buyer buyer) {
            synchronized (buyers) {
                super.addLast(buyer);
                if (Runner.countCashier < 5 && Queues.buyers.size() > Runner.countCashier * 2) {
                    Cashier cashier = new Cashier(++Runner.countCashier);
                    new Thread(cashier).start();
                }
            }
        }
    };
}

