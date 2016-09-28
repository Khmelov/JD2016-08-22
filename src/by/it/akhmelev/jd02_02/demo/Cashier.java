package by.it.akhmelev.jd02_02.demo;

public class Cashier implements Runnable {
    @Override
    public void run() {
        try {
            Buyer buyer;

            while (true) {
                synchronized (Queues.buyers) {
                    buyer = Queues.buyers.pollFirst();
                    if (Queues.buyers.size() == 0)
                        break;
                }
                System.out.println(buyer + " пришел в кассу ИМЯ_КАССЫ");
                Thread.sleep(1000);
                //service
                System.out.println(buyer + " завершил обслуживание в кассе ИМЯ_КАССЫ");
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            System.out.println("ИМЯ_КАССЫ закрылась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runner.countCashiers--;
    }
}
