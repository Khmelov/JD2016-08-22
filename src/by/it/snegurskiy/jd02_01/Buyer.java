package by.it.snegurskiy.jd02_01;

import java.util.HashMap;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public class Buyer extends Thread implements IBuyer, Runnable, IUseBasket {

    int number;
              boolean pensioner=false;



    public Buyer(Integer number) {
        this.number=number;
        if (number%4==0&number!=0) pensioner=true;
        if (pensioner==true) this.setName("Покупатель №"+number.toString()+ " пенсионер");
        else this.setName("Покупатель №"+number.toString());

        start();

    }

    public void run() {
        enterToMarket(); //вошел в магазин (мгновенно)
        takeBasket(); //взял корзину
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        putGoodsToBasket(); //положил выбранный товар в корзину
        goToOut(); //отправился на выход(мгновенно)
        Runner0201.countBuyers--;
        System.out.println("В магазине покупателей "+Runner0201.countBuyers+"; За день покупателей  "+Runner0201.countBuyer);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " зашел в магазин");

    }

    @Override
    public void chooseGoods() {
        int pause=TimeHelper.random(500,2000);
        try {
            if (pensioner==true) {
                sleep(pause*1,5);
                System.out.println("медлит пенсионер:)");
            }
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

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
        int pause=TimeHelper.random(100,200);
        try {
            if (pensioner==true) sleep(pause*1,5);
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " взял корзину");

    }

    @Override
    public void putGoodsToBasket() {
        int pause=TimeHelper.random(100,200);
        try {
            if (pensioner==true) sleep(pause*1,5);
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String, Double> a=Basket.GoodsInBasket();

        System.out.println(this + " положил в корзину "+a);

    }
}
