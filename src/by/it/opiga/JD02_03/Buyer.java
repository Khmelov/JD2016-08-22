package by.it.opiga.JD02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    int num;//номер покупателя
    boolean pensioner = false;
    HashMap<String, Integer> goods = new HashMap();

    public Buyer(int num) {
        Goods.setGoods();
        this.num = num;
        this.setName("Покупатель № " + num);
        if (num % 4 == 0) {
            pensioner = true;
        }
        start();
    }

    @Override
    public void run() {//покупатель приходит и выбирает товары
        enterToMarket();
        chooseGoods();
        waitService();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин ");
    }

    @Override
    public void chooseGoods() {
//        try {
//            int pause = Helper.random(1000,2000);
//            Thread.sleep(pause);
//        } catch (InterruptedException e) {
//            System.out.println(this + " некорректное завершение ожидания ");
//        }
        takeBasket();
        putGoodsToBasket();
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина ");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void putGoodsToBasket() {
        int col = Helper.random(1, 4);
        try {
            for (int i = 0; i < col; i++) {
                Map.Entry<String, Integer> me = Goods.getGoots();
                goods.put(me.getKey(), me.getValue());
                if (pensioner)
                    Thread.sleep(Helper.random(100, 200) * (long) 1.5);
                else
                    Thread.sleep(Helper.random(100, 200));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар(ы) " + goods);
        Set<Map.Entry<String, Integer>> good = goods.entrySet();
        Iterator<Map.Entry<String, Integer>> igoods = good.iterator();
        int sum = 0;
        for (Map.Entry s : good) {
            Map.Entry<String, Integer> me = igoods.next();
            sum += me.getValue();
        }
        System.out.println(this + " общая сумма чека " +sum);
    }

    @Override
    public void takeBasket() {
        try {
            Thread.sleep(Helper.random(100, 200));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " взял корзину ");
    }

    @Override
    public void waitService() {
        System.out.println(this + " встал в очередь");
        synchronized (Queues.buyers) {
            Queues.buyers.addLast(this);
        }
        synchronized (this) {
            try {
                System.out.println(this + " ожидает в очереди");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this + " закончил обслуживаться");
            }
        }

    }
}
