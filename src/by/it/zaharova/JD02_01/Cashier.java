package by.it.zaharova.JD02_01;

public class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        try {
            while (true) {

          //  boolean stop = false;//для всех(пока есть люди)
            Buyer buyer;
            synchronized (Queues.buyers) {
//        int size=0;
//        while (size<5){//пока меньше 5 человек в очереди
//            synchronized (Queues.buyers){
//                size = Queues.buyers.size();
//            }
//        }
//        if (size>0 && countCashiers<5) {
//            Cashier cashier = new Cashier();
//            new Thread(cashier).start();
//            countCashiers++;
//        }


                if (Queues.buyers.size() == 0)
                    break;
                buyer = Queues.buyers.pollFirst();
            }
                System.out.println(buyer + "обслуживается в "+this);
                Thread.sleep(2000); //обслуживание
                System.out.println(buyer + "обслужен в "+this);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            System.out.println(this+" закрылась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runner.countCashiers--;

    }
    @Override
    public String toString() {
        return "Касса №" + number;
    }
}
