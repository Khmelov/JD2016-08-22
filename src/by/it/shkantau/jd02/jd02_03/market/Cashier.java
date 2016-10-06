package by.it.shkantau.jd02.jd02_03.market;

import java.util.Currency;
import java.util.Locale;
import java.util.Map;

public class Cashier extends Thread {

    private Double cashProceed = 0.0;
    private String name;

    public Cashier(String name) {
        this.name = name;
//        this.start();
    }

    @Override
    public void run() {
        Buyer buyer;

        while (Dispatcher.cashesIsWorked.get()){
//  kill thread if there is no buyersList buyersList
            buyer = QueueOfBuyers.poll();

            if (buyer != null) {
                // sleep service time;
                Dispatcher.sleep((int)(1000*(3.0*Math.random()+2)));
                cashProceed += buyer.getBucket().getTotalSum();
                RunnerMarket.addProceeds(buyer.getBucket().getTotalSum());
                RunnerMarket.getBuyersList().remove(buyer);
                printCheck(buyer.toString(), buyer.getBucket());

                if (RunnerMarket.getBuyersList().size()==0){
                    Dispatcher.cashesIsWorked.set(false);
                }

//  wakeUp Buyer
                synchronized (buyer) {
                    buyer.readyToGoOutFromCash = true;
                    buyer.notify();
                }
            }
        }
        Printer.print(String.format("%s is closed. CashProceed = %.2f\n",this, cashProceed));
        Dispatcher.cashiersCounter.getAndDecrement();
    }

    private void printCheck(String name ,Bucket buyerBucket){
        StringBuilder text = new StringBuilder();
        text.append(String.format("\n%s services check, %s\n", name, this));
        int indexOfGoods = 1;
        for (Map.Entry<Goods, Double> entry : buyerBucket.getGoodsInBucket().entrySet()) {
            text.append(String.format("%-2d%-15s%-2.2f*%-6.2f\n", indexOfGoods++, entry.getKey().getName(), entry.getValue(), entry.getKey().getCost()));
        }
        text.append("---------------------------\n");
        text.append(String.format("Total            %.2f %s\n\n",buyerBucket.getTotalSum(), Currency.getInstance(new Locale("ru", "ru"))));
        Printer.print(text.toString());
    }

    @Override
    public String toString() {
        return  "Cash" + this.name;
    }
}
