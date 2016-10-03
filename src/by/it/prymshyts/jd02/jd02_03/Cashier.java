package by.it.prymshyts.jd02.jd02_03;

import java.util.Formatter;
import java.util.concurrent.ConcurrentLinkedDeque;

class Cashier extends Thread{

    final private Cashbox cashbox = new Cashbox();
    final private ConcurrentLinkedDeque<String> checks;

    private ConcurrentLinkedDeque<Buyer> buyersQueue = new ConcurrentLinkedDeque<>();
    final private Market currentMarket;
    private int cashierNum;

    public void run() {
        while (currentMarket.getState() != MarketState.CLOSED) {
            handleBuyer();
        }
    }

    Cashier(int num, Market market, ConcurrentLinkedDeque<String> checks) {
        setName("Касса №" + num);
        cashierNum = num;
        currentMarket = market;
        this.checks = checks;
    }

    void addBuyerToQueue(Buyer buyer) {
        if (buyer.isPensioner()) {
            buyersQueue.addFirst(buyer);
        } else {
            buyersQueue.add(buyer);
        }
    }

    private void handleBuyer() {
        if (!buyersQueue.isEmpty()) {
            synchronized (cashbox) {
                Buyer buyer = buyersQueue.remove();
                currentMarket.increaseGain(buyer.getBasketTotalCost());
                checks.add(getCheck(buyer,cashierNum));
                cashbox.handleBuyer(buyer);
            }
        }
    }

    int getQueueSize() {
       return buyersQueue.size();
    }

    private String getCheck(Buyer buyer, int cashierNum) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        formatter.format(Logger.getWhitespaceString(cashierNum) + "-------------------------\n");
        formatter.format(Logger.getWhitespaceString(cashierNum) + "|%1$1s%2$-14d|\n", "Кассир №", cashierNum + 1);
        formatter.format(buyer.getGoodsFromBasket(cashierNum));
        formatter.format(Logger.getWhitespaceString(cashierNum) + "|%1$-17s %2$5d|\n", "Всего товаров:", buyer.getBasketGoodsCount());
        formatter.format(Logger.getWhitespaceString(cashierNum) + "|%1$-17s %2$5d|\n", "Полная стоимость:", buyer.getBasketTotalCost());
        formatter.format(Logger.getWhitespaceString(cashierNum) + "-------------------------\n");

        return sb.toString();
    }
}
