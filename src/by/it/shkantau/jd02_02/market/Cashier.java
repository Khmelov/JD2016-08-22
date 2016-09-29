package by.it.shkantau.jd02_02.market;

public class Cashier implements Runnable {
    private String name;

    public Cashier(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        Buyer buyer;
        boolean serviceStatus = false;

        while (true) {
//  kill thread if there is no buyersList buyersList
            synchronized (RunnerMarket.getBuyersList()){
                if(RunnerMarket.getBuyersList().size()==0){
                    break;
                }
            }
            synchronized (Queues.queueOfBuyers) {
                if (Queues.queueOfBuyers.size() > 0) {
                    buyer = Queues.queueOfBuyers.pollFirst();
                    System.out.println(buyer + " services in " + this + " " + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);
                    serviceStatus = true;
//  wakeUp Buyer
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            }
// sleep service time;
            if (serviceStatus){
                serviceStatus = false;
                try {
                    Thread.sleep(Helper.random(2.0, 5.0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

            System.out.println(this + " is closed." + (double)(System.currentTimeMillis() - RunnerMarket.getStartMils())/1000);

    }

    @Override
    public String toString() {
        return  "Cash" + this.name;
    }
}
