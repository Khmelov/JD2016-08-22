package by.it.dubatovka.jd02_02;

class Cashier implements Runnable {
    private final int num;

    public Cashier(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            Buyer buyer;
            synchronized (Queues.buyers) {
                if (Queues.buyers.size() == 0) break;
                buyer = Queues.buyers.pollFirst();
            }
            try {


                synchronized (buyer) {
                    System.out.println(buyer + " обслуживается в Кассе № " + num);
                    Thread.sleep(2500);
                    buyer.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(buyer + " обслужен.");
        }

        System.out.println("Касса №" + num + " закрылась");
        Runner.countCashier--;
    }
}
