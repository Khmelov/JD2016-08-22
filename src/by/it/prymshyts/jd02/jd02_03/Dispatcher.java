package by.it.prymshyts.jd02.jd02_03;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher extends Thread{

    private AtomicInteger buyersCount = null;
    private CopyOnWriteArrayList<Cashier> workingCashiers = null;
    private CopyOnWriteArrayList<Cashier> prepareToWorkCashiers = null;
    private CopyOnWriteArrayList<Cashier> prepareToWaitCashiers = null;
    private CopyOnWriteArrayList<Cashier> waitingCashiers = null;

    Dispatcher(AtomicInteger buyersCount,
               CopyOnWriteArrayList<Cashier> workingCashiers,
               CopyOnWriteArrayList<Cashier> prepareToWorkCashiers,
               CopyOnWriteArrayList<Cashier> prepareToWaitCashiers,
               CopyOnWriteArrayList<Cashier> waitingCashiers) {

        this.buyersCount = buyersCount;
        this.workingCashiers = workingCashiers;
        this.prepareToWorkCashiers = prepareToWorkCashiers;
        this.prepareToWaitCashiers = prepareToWaitCashiers;
        this.waitingCashiers = waitingCashiers;
    }

    @Override
    public void run() {
        while (workingCashiers.size() > 0 || prepareToWorkCashiers.size() > 0 || prepareToWaitCashiers.size() > 0 || waitingCashiers.size() > 0) {
            processCashiersList();
            processCashiers();
        }
    }

    private void processCashiersList() {
        double needCashiers = Math.min(IMarket.CASHIERS_NUM, Math.floor(buyersCount.get() / IMarket.CASHIERS_NUM));
        double availableCashiers = workingCashiers.size();
        double cashiersDiff = needCashiers - availableCashiers;

        if (cashiersDiff > 0) {
            for (int i = 0; i < cashiersDiff; i++) {
                prepareToWorkCashiers.add(waitingCashiers.remove(i));
            }
        } else if (cashiersDiff < 0) {
            for (int i = 0; i < cashiersDiff; i++) {
                prepareToWaitCashiers.add(workingCashiers.remove(i));
            }
        }
    }

    @SuppressWarnings("all")
    private void processCashiers() {
        if (prepareToWaitCashiers.size() > 0) {
            for (int i = 0; i < prepareToWaitCashiers.size(); i++) {
                Cashier cashier = prepareToWaitCashiers.get(i);

                if (cashier.getQueueSize() == 0) {
                    synchronized (cashier) {
                        try {
                            waitingCashiers.add(prepareToWaitCashiers.remove(i));
                            cashier.wait();
                        } catch (InterruptedException e) {
                            System.err.println(cashier.getName() + " не был поставлен на паузу.");
                        }
                    }
                }
            }
        }

        if (prepareToWorkCashiers.size() > 0) {
            for (int i = 0; i < prepareToWorkCashiers.size(); i++) {
                Cashier cashier = prepareToWorkCashiers.get(i);
                synchronized (cashier) {
                    cashier.notify();
                    workingCashiers.add(prepareToWorkCashiers.remove(i));
                }
            }
        }
    }
}
