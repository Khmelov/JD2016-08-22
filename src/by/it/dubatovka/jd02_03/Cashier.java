package by.it.dubatovka.jd02_03;

class Cashier implements Runnable {
    private final int num;

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
                    System.out.println(this + ": Обслуживает клиента: " + buyer);
                    Rnd.fromTo(2000, 5000);
                    System.out.println(this + ": Обслужил клиента: " + buyer);
                    Manager.countCompleteBuyers.addAndGet(1);
                    buyer.iWait = false;
                    buyer.notify();
                }
            } else {
                Rnd.fromTo(1000, 1000);
            }
        }
        System.out.println("Кассир " + num + " закрыл кассу");
    }
}
