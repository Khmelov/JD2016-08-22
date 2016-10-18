package by.it.kisel.JD02_01;

import java.util.Set;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    int num;                    //номер покупателя
    public boolean iWait=false; //флаг того, что покупатель в ожидании
    Basket basket;

    //конструктор покупателя с его номером
    public Buyer() {
        num=++Dispatcher.countBuyers;
        this.setName("Покупатель № "+ num +" ");
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToQueue();
        goToOut();
    }


    @Override
    public String toString() {
        return this.getName();
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
                int pause = Helper.fromTo(100, 200);
                Set<String> keyGoods = Helper.allPriceForGoods.keySet();
                int numberGood = Helper.random(0, keyGoods.size() - 1);
                String keyGood = (String) keyGoods.toArray()[numberGood];
                putGoodsToBasket(keyGood, (float) Math.random()+10);
                sleep(pause);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

    }

    @Override
    public void goToQueue() {
        synchronized (this) { //Специально явно сделана блокировка по покупателю
            //если бы synchronized был указан в методе, то он работает именно так
            //при "отпускании" этого потока
            //кассир - отправитель команды для продолжения этого потока
            //должен будет тоже заблокировать этого же покупателя
            //и оправить ему notify.
            System.out.println(this + "встал в очередь на кассу");
            Queues.add(this);
            //в этой точке поток должен остановиться, поэтому
            //подготовим публичное поле iWait для определения, можно ли идти дальше
            iWait=true;
            while (iWait) try { //ожидаем notify и iWait==false от кассира.
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //ожидание окончено, тут прилетел notify от кассира
            System.out.println(this + "закончил оплату товаров в кассе");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");

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
