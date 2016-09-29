package by.it.shkantau.jd02_01;

public class Cashier implements Runnable {
    private String name;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public void run() {

            Buyer buyer;
            while (true) {
                synchronized (Queues.buyers) {
                    buyer = Queues.buyers.pollFirst();
                    if (Queues.buyers.size() == 0) {
                        break;
                    }
                }

                System.out.println(buyer + "services in cash "+ name);

                synchronized (buyer) {
                    buyer.notify();
                }
            }
            System.out.println("Cash "+ name + " is closed");

    }

    @Override
    public String toString() {
        return this.name;
    }
}
