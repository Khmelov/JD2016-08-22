package by.it.snegurskiy.jd02_02;

import by.it.snegurskiy.jd02_01.*;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Buyer extends Thread implements Runnable, IBuyer{

    int number;



    public Buyer(Integer number) {
        super("Покупатель №" + number.toString());
        this.number = number;
        start();
    }

    @Override
    public void run() {
        enterToMarket(); //вошел в магазин (мгновенно)
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        goToOut(); //отправился на выход(мгновенно)
        takeBasket(); //взял корзину
        putGoodsToBasket(); //положил выбранный товар в корзину
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");
    }

    @Override
    public void chooseGoods() {
        int pause=TimeHelper.random(500,2000);
        try {
            sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел в магазин");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " взял корзинку");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " положил товар в корзинку");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
