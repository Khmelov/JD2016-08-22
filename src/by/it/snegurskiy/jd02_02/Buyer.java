package by.it.snegurskiy.jd02_02;

import by.it.snegurskiy.jd02_01.*;

import java.util.HashMap;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Buyer extends Thread implements Runnable, IBuyer{

    int number;
    public boolean pensioner=false;

    public Buyer(Integer number) {

        this.number = number;
        if (number%4==0&number!=0) pensioner=true;
        if (pensioner==true) this.setName("Покупатель ПЕНСИОНЕР № " + number + " ");
        else this.setName("Покупатель № " + number + " ");
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
    public void chooseGoods() {int pause=TimeHelper.random(500,2000);
        try {
            if (pensioner==true){
                sleep(pause*1,5);
                System.out.println("ПЕНСИОНЕР медлит");
            }
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " выбрал товар");

    }

    @Override
    public void goToOut() {
        System.out.println(this + " вышел  из магазина");
    }

    @Override
    public void takeBasket() {

        int pause = TimeHelper.random(100, 200);
        try {
            if (pensioner == true) {
                sleep(pause*1,5);
                System.out.println("ПЕНСИОНЕР медлит");
            }
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(this + " взял корзинку");
        }
    }

    @Override
    public void putGoodsToBasket() {
        int pause=TimeHelper.random(100,200);
        try {
            if (pensioner==true){
                sleep(pause*1,5);
                System.out.println("ПЕНСИОНЕР медлит");
            }
            else sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap a=Basket.GoodsInBasket();
        System.out.println(this +  " положил "+ a+" в корзинку");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
