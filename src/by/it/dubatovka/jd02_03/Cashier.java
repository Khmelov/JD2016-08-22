package by.it.dubatovka.jd02_03;

class Cashier implements Runnable {
    private final int num;
    private double price;

    public Cashier(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Кассир " + num;
    }


    @Override
    public void run() {
        System.out.println(this + " открыл кассу");
        while (!Manager.finish()) {
            Buyer buyer = QueueBuyers.poll();
            if (buyer != null) {
                synchronized (buyer) {
                    double sum = 0;
                    Manager.sleep(Rnd.fromTo(2000, 5000));
                    System.out.println(this + " обслуживает клиента: " + buyer);
                    System.out.println("------------------------------------------");
                    for (Good good : buyer.basket) {
                        price = PriceList.goods.get(good);
                        System.out.printf("%-7s%2s%3.1f%5s", good, ": ", price, " руб.");
                        System.out.println();
                        sum += price;

                    }
                    System.out.printf("%16s%-3.2f%5s", "Всего к оплате: ", sum, " руб.");
                    System.out.println();
                    System.out.println("------------------------------------------");
                    System.out.println(this + ": Обслужил клиента: " + buyer);
                    Manager.countCompleteBuyers.addAndGet(1);
                    buyer.iWait = false;
                    buyer.notifyAll();
                }
            } else {
                Manager.sleep(1000);
            }
        }
        System.out.println("Кассир " + num + " закрыл кассу");
    }
}
