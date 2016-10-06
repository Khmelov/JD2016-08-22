package by.it.grechishnikov.jd02_03;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;


public class Buyer extends Thread implements IBuyer, IUseBucket {
    CopyOnWriteArraySet<Good> bucket;
    private boolean pensioner;
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public Buyer(int id) {
        super(String.valueOf(id));
    }

    public Buyer(int id, boolean pensioner) {
        this(id);
        this.pensioner = pensioner;
    }

    public void run() {
        enterToMarket();
        takeBucket();
        chooseGoods();
        waitService();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        try {
            countDownLatch.countDown();
            countDownLatch.await();
            Dispatcher.store.put(this); //заходим в магазин
            Dispatcher.hall.put(this); //заходим в торговый зал
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBucket() {
        bucket = new CopyOnWriteArraySet<>();
    }

    @Override
    public void chooseGoods() {
        try {
            sleep(2000);//выбирает товар
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = ThreadLocalRandom.current().nextInt(1, 4);
        for (int i = 0; i < count; i++) {
            Good good;
            do {
                good = Good.getRandomGood();
            } while(!putGoodsToBucket(good));
        }
    }

    @Override
    public boolean putGoodsToBucket(Good good) {
        return bucket.add(good);
    }

    @Override
    public void waitService() {
        Dispatcher.hall.remove(this);
        Cashier.queue.addLast(this);
    }

    @Override
    public void goToOut() {
        while(Cashier.queue.contains(this)) {
            try {
                sleep(500); //ждем, пока нас расчитают на кассе и выходим
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Dispatcher.store.remove(this);
    }

    boolean isPensioner() {
        return pensioner;
    }

    void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }
}
