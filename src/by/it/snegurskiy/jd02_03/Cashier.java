package by.it.snegurskiy.jd02_03;

/**
 * Created by snegurskiy.nn on 28.09.2016.
 */
public class Cashier implements Runnable {

    @Override
    public void run() {
        try {
           Buyer buyer;
            int size=0;
            while (size<5){
                synchronized (QueueBuyer.buyers) {
                    size = QueueBuyer.buyers.size();
                }
                Thread.sleep(100);
            }

                while (true) {
                    synchronized (QueueBuyer.buyers) {
                        buyer = QueueBuyer.buyers.pollFirst();
                        if (QueueBuyer.buyers.size() == 0) break;
                    }
                    System.out.println(buyer + "обслуживается в кассе ИМЯ_КАССЫ");
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }

        } catch (InterruptedException e){
        System.out.println(e);}
    }

}