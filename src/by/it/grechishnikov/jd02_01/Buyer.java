package by.it.grechishnikov.jd02_01;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


class Buyer extends Thread implements IBuyer, IUseBucket {
    Map<Good, Double> goods = new HashMap<>();
    private boolean pensioner;
    private long start;
    private volatile boolean canGo = false;

    Buyer(String name) {
        super(name);
        start = System.currentTimeMillis();
    }

    Buyer(String name, boolean pensioner) {
        super(name);
        this.pensioner = pensioner;
        start = System.currentTimeMillis();
    }

    public void run() {
        enterToMarket();    //заходим в магазин
        takeBucket();       //берем корзину
        chooseGoods();      //выбираем товар
        putGoodsToBucket(); //кладем товар в корзину
        waitService();      //идем на кассу
        goToOut();          //выходим из магазина
        printResult();      //печатаем результат
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин.");
    }

    @Override
    public void takeBucket() {
        sleep(0.1, 0.2);
    }

    @Override
    public void chooseGoods() {
        sleep(0.5, 2.0);
    }

    @Override
    public void putGoodsToBucket() {
        sleep(0.1, 0.2);
        int count = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < count; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, Good.values().length);
            Good good = Good.values()[index];
            goods.put(good, good.getPrice());
        }
    }

    @Override
    public void goToOut() {
    }

    @Override
    public String toString() {
        return getName() + ": ";
    }

    private void sleep(double from, double to) {
        double time = ThreadLocalRandom.current().nextDouble(from, to);
        try {
            sleep((int) (time * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printResult() {
        double result = System.currentTimeMillis() - start;
        System.out.println(this + "провел в магазине " + result + " милисек.");
    }

    public boolean isPensioner() {
        return pensioner;
    }

    @Override
    public void waitService() {
        if(!pensioner) {
            Cashier.buyers.add(this);
        } else {
            Cashier.buyers.push(this);
        }
        while(true) {
            if(canGo) {
                break;
            }
        }
    }

    public void setCanGo(boolean canGo) {
        this.canGo = canGo;
    }
}