package by.it.prymshyts.jd02.jd02_03;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Market implements IMarket {

    private MarketState state = MarketState.CLOSED;

    final private Semaphore tradeHole = new Semaphore(10);

    private int buyerCounter = 0;   // Для уникальных номеров покупателей.
    private AtomicInteger buyersCount = new AtomicInteger(0);
    private AtomicInteger gain = new AtomicInteger(0);

    private CopyOnWriteArrayList<Cashier> workingCashiers = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Cashier> prepareToWorkCashiers = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Cashier> prepareToWaitCashiers = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Cashier> waitingCashiers = new CopyOnWriteArrayList<>();
    private ConcurrentLinkedDeque<String> checks = new ConcurrentLinkedDeque<>();

    private ConcurrentLinkedQueue<Good> goods = new ConcurrentLinkedQueue<>();

    private Timer timer = null;


    @Override
    public void open() {
        state = MarketState.OPENED;
        prepareCashiers();
        prepareGoods();
        timer = new Timer(WORKING_TIME);

        new Dispatcher(buyersCount, workingCashiers, prepareToWorkCashiers, prepareToWaitCashiers, waitingCashiers).start();
    }

    @Override
    public void close() {
        while (buyersCount.get() > 0) {
            printLog();
            ManagerController.pause();
        }
        state = MarketState.CLOSED;
        ManagerController.pause(100);

        workingCashiers.clear();
        prepareToWorkCashiers.clear();
        prepareToWaitCashiers.clear();
        waitingCashiers.clear();
    }

    @Override
    public void letBuyersEnter() {
        if (buyersCount.get() >= MAX_BUYERS) {
            return;
        }

        int buyersNum = 0;
        int currentSec = timer.getCurrentSecond();
        int expectedBuyers;

        if (currentSec < 30) {
            expectedBuyers = 10 + currentSec;
            if (!(buyersCount.get() >= expectedBuyers)) {
                buyersNum = expectedBuyers - buyersCount.get();
            }
        } else if (currentSec > 30) {
            expectedBuyers = 40 + (30 - currentSec);
            if (buyersCount.get() <= expectedBuyers) {
                buyersNum = expectedBuyers - buyersCount.get();
            }
        }

        enter(buyersNum);
    }

    @Override
    public MarketState getState() {
        return state;
    }

    @Override
    public void workTick() {
        if (!timer.tick()) {
            state = MarketState.PREPARING_TO_CLOSE;
        }
        printLog();
    }

    private synchronized void prepareCashiers() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < CASHIERS_NUM; i++) {
            Cashier cashier = new Cashier(i, this, checks);
            executor.execute(cashier);
            waitingCashiers.add(cashier);
        }
        executor.shutdown();
    }

    Semaphore getTradeHole() {
        return tradeHole;
    }

    private void prepareGoods() {
        for (int i = 1; i <= MAX_GOODS; i++) {
            goods.add(new Good());
        }
    }

    private void enter(int numberOfBuyers) {
        for (int i = 1; i <= numberOfBuyers; i++) {
            new Buyer(++buyerCounter, this).start();
        }
    }

    void increaseBuyersCount() {
        buyersCount.getAndIncrement();
    }

    void decreaseBuyersCount() {
        buyersCount.getAndDecrement();
    }

    CopyOnWriteArrayList<Cashier> getCashiers() {
        return workingCashiers;
    }

    Good giveGood() {
        return goods.remove();
    }

    void increaseGain(int gain) {
        this.gain.getAndAdd(gain);
    }

    private void printLog() {
        String log = "Магазин работает: " + timer.workingTime() + System.lineSeparator() +
                "Текущая секнунда минуты: " + timer.getCurrentSecond() + System.lineSeparator() +
                "Число покупателей: " + buyersCount.get() + System.lineSeparator() +
                "Число работающих кас: " + workingCashiers.size() + System.lineSeparator() +
                "Число ожидающих кас: " + waitingCashiers.size() + System.lineSeparator() +
                "Число готовящихся ожидать кас: " + prepareToWaitCashiers.size() + System.lineSeparator() +
                "Число готовящихся работать кас: " + prepareToWorkCashiers.size() + System.lineSeparator() +
                "Выручка магазина: " + gain;
        Logger.marketLog(log);

        if (checks.size() > 0) {
            Logger.checkLog(checks.remove());
        }
    }
}
