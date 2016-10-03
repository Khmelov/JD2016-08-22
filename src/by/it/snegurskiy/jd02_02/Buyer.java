package by.it.snegurskiy.jd02_02;

import java.util.*;
import java.util.Map.Entry;


/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Buyer extends Thread implements Runnable, IBuyer{

    int number;
    public boolean pensioner=false;
    ArrayList basket;

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
        takeBasket(); //взял корзину
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        putGoodsToBasket(); //положил выбранный товар в корзину
        waitService();     //встал в очередь и ожидает обслуживание
        goToOut(); //отправился на выход(мгновенно)
    }


    @Override
    public void waitService() {
        System.out.println(this + "встал в очередь");
        synchronized (QueueBuyer.buyers) {
            QueueBuyer.buyers.addLast(this);
        }
        synchronized (this) {
            try {
                System.out.println(this + "ожидает в очереди");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(this + "закончил обслуживаться");
            }
        }

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
        this.basket=Basket.GoodsInBasket();
        double sum=0;
        for (int i = 0; i <this.basket.size() ; i++) {
            sum=sum+Helper.allGoods.get(this.basket.get(i));
        }
                    System.out.println(this +  " положил "+ this.basket.toString()+" в корзинку "+" сумма покупки "+ sum);
        }


    @Override
    public String toString() {
        return this.getName();
    }
}
