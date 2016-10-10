package by.it.zaharova.JD02_01;

import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    // int number;

    String keyGood;
    Basket basket;

    public Buyer(Integer number) {
        super("Покупатель №" + number.toString());
        //this.number = number;
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        waitService();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашёл в магазин");

    }

    @Override
    public void chooseGoods() {
        int count = Helper.random(1, 4);
        try {
            for (int i = 0; i < count; i++) {
                int pause = Helper.random(100, 200);
                Set<String> keyGoods = Helper.allPriceForGoods.keySet();
                int numberGood = Helper.random(0, keyGoods.size() - 1);
                String keyGood = (String) keyGoods.toArray()[numberGood];
                putGoodsToBasket(keyGood, (float) Math.random() + 10);
                sleep(pause);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

    }

    @Override
    public void waitService() {
        System.out.println(this+" стал в очередь");
        synchronized (Queues.buyers) {  //одновреммено не зайдёт // синхронизируется на очереди попкупателей
            Queues.buyers.addLast(this);
        }

        synchronized (this) {
            try {
                System.out.println(this + " ожидает в очереди");
                this.wait();   //покупатель ожидает(так как дальше его обсл др поток, в нашем случае кассир)//выводит из стопа другой поток
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this + " закончил обслуживаться");
            }
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        basket = new Basket(); // можно брать без очереди
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBasket(String name, Float count) {
        basket.putGood(name, count);
        System.out.println(this + " выбрал товар " + name + " в количестве " + count);

    }
}
