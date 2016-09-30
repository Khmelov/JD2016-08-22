package by.it.aborisenok.JD02_02;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Лёша on 28.09.2016.
 */
public class Queues {

    public static Deque<Buyer> buyerDeque = new ArrayDeque<Buyer>(){
        @Override
        public void addLast(Buyer buyer) {
            synchronized (buyerDeque) {
                super.addLast(buyer);

                if (Runner.countCashiers < 5 && Queues.buyerDeque.size()>Runner.countCashiers*2) {
                    Cashier cashier = new Cashier(++Runner.countCashiers);
                    new Thread(cashier).start();
                }
            }
        }
    };
}
