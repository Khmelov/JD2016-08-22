package by.it.snegurskiy.jd02_02;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Cashier implements Runnable{

    private int number;

    Cashier(int number) {
        this.number=number;
    }


    @Override
    public void run() {
            try {
                while (true) {
                    Buyer buyer;
                    synchronized (QueueBuyer.buyers) {
                        if (QueueBuyer.buyers.size() == 0)
                            break;
                        buyer = QueueBuyer.buyers.pollFirst();
                    }
                    System.out.println(buyer + "обслуживается в "+this);
                    Thread.sleep(2500);
                    System.out.println(buyer + "обслужен в "+this);
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
                System.out.println(this+" закрылась");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Runner0202.countCashiers--;
        }

    @Override
    public String toString() {
        return "Касса №" + number;
    }

    }

