package by.it.grechishnikov.jd02_03;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadLocalRandom;


public class Buyer extends Thread implements IBuyer, IUseBucket {
    CopyOnWriteArraySet<Good> bucket;
    private boolean pensioner;

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
            Dispatcher.hall.put(this);
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
        if(!pensioner) {
            Cashier.queue.addLast(this);
        } else {
            Cashier.pensionerQueue.addLast(this);
        }
    }

    @Override
    public void goToOut() {

    }

    public boolean isPensioner() {
        return pensioner;
    }

    void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }
}
