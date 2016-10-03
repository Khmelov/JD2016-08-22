package by.it.prymshyts.jd02.jd02_03;

import by.it.prymshyts.jd01.jd01_02.Util;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.concurrent.CopyOnWriteArrayList;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private Market currentMarket = null;

    private ArrayList<Good> basket = new ArrayList<>();
    private boolean pensioner = false;


    Buyer(int num, Market currentMarket) {
        this.currentMarket = currentMarket;
        setName("Покупатель №" + num);
        pensioner = pensionerCheck();
    }

    @Override
    public void run() {
        enterInMarket();
        takeBasket();
        enterTradeHole();
        chooseGoods();
        putGoodsToBasket();
        exitTradeHole();
        waitInQueue(findCashier());
        goToExit();
    }

    @Override
    public void enterInMarket() {
        Logger.buyersLog(getName() + " вошёл в магазин.");
        currentMarket.increaseBuyersCount();
    }

    @Override
    public void chooseGoods() {
        handleOperationTime(BuyerOperationTime.CHOOSE_GOODS);
        Logger.buyersLog(getName() + " выбрал товар.");
    }

    @Override
    public void putGoodsToBasket() {
        int goodsNumber = Util.getRandomNum(1, 4);

        for (int i = 0; i < goodsNumber; i++) {
            basket.add(currentMarket.giveGood());
        }

        handleOperationTime(BuyerOperationTime.PUT_GOODS_TO_BASKET);
        Logger.buyersLog(getName() + " положил товар в корзинку.");
    }

    @Override
    public void goToExit() {
        Logger.buyersLog(getName() + " вышел из магазина.");
        currentMarket.decreaseBuyersCount();
    }

    @Override
    public void takeBasket() {
        handleOperationTime(BuyerOperationTime.TAKE_BASKET);
        Logger.buyersLog(getName() + " взял корзинку.");
    }

    @Override
    public Cashier findCashier() {
        CopyOnWriteArrayList<Cashier> cashiers = currentMarket.getCashiers();
        Cashier chosenCashier = null;

        while (chosenCashier == null) {
            if (cashiers.size() != 0) {
                chosenCashier = cashiers.get(0);
            } else {
                ManagerController.pause(100);
            }
        }

        for (Cashier cashier : cashiers) {
            if (cashier.getQueueSize() < chosenCashier.getQueueSize()) {
                chosenCashier = cashier;
            }
        }

        return chosenCashier;
    }

    @Override
    public synchronized void waitInQueue(Cashier cashier) {
        try {
            Logger.buyersLog(getName() + " встал в очередь.");
            cashier.addBuyerToQueue(this);
            wait();
        } catch (InterruptedException e) {
            System.err.println("Ошибка у " + getName() + " при ожидании в очереди.");
        }
        Logger.buyersLog(getName() + " вышел из очереди.");
    }

    @Override
    public void enterTradeHole() {
        try {
            currentMarket.getTradeHole().acquire();
        } catch (InterruptedException e) {
            System.err.println(getName() + " не смог войти в зал.");
        }
    }

    @Override
    public void exitTradeHole() {
        currentMarket.getTradeHole().release();
    }

    boolean isPensioner() {
        return pensioner;
    }

    int getBasketTotalCost() {
        int totalCost = 0;

        for (Good good: basket) {
            totalCost += good.getCost();
        }

        return totalCost;
    }

    int getBasketGoodsCount() {
        return basket.size();
    }

    String getGoodsFromBasket(int cashierNum) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);

        for (Good good : basket) {
            formatter.format(Logger.getWhitespaceString(cashierNum) + "|%1$-10s   -    %2$4d|\n", good.getName(), good.getCost());
        }

        return sb.toString();
    }


    private void handleOperationTime(BuyerOperationTime type) {
        int operationTime;
        switch (type) {
            case CHOOSE_GOODS:
                operationTime = Util.getRandomNum(500, 2000);
                break;
            case TAKE_BASKET:
                operationTime = Util.getRandomNum(100, 200);
                break;
            case PUT_GOODS_TO_BASKET:
                operationTime = Util.getRandomNum(100, 200);
                break;
            default:
                operationTime = 0;
                break;
        }
        operationTime *= pensioner ? 1.5 : 1;
        ManagerController.pause(operationTime);
    }

    private boolean pensionerCheck() {
        return Util.getRandomNum(1, 4) == 4;
    }
}
