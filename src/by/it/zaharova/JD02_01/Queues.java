package by.it.zaharova.JD02_01;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queues {

    static final Deque<Buyer> buyers = new ArrayDeque<Buyer>() {
        @Override
        public void addLast(Buyer buyer) {
            synchronized (buyers) { //мы не знаем из какого потока будет вызвано добавление
                super.addLast(buyer);
                if (Runner.countCashiers < 5 && Queues.buyers.size()>Runner.countCashiers*2) {
                    Cashier cashier = new Cashier(++Runner.countCashiers);
                    new Thread(cashier).start();
                }
            }
        }
    };
}
