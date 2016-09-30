package by.it.aborisenok.JD02_01;

import java.util.Set;

/**
 * Created by Лёша on 26.09.2016.
 */
public class Buyer  implements IBuyer, IUseBacket, Runnable{

    Backet backet;
    private String name;
    boolean pensioneer = false;
    double pensCoefficient = 1.5;


    public Buyer(int number){
        if (number%4 != 0)
        name = ("Buyer №" + number);
        else {
            pensioneer = true;
            name = ("Buyer pensioneer №" + number);
        }

    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market.");
        int pause = Helper.random(100, 200);
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeBacket() {
        backet = new Backet();
        System.out.println(this + " take the backet.");
        int pause = Helper.random(100, 200);
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void chooseGoods() {
        int count = Helper.random(1, 4);
        try {
            for (int i = 0; i < count; i++) {
                int pause = Helper.random(500, 2000);
                String keyGood = Helper.getKeyGood();
                putGoodToBacket(keyGood, (int)(Math.random()*10));
                    if (!pensioneer){
                        Thread.sleep(pause);
                    } else {
                        Thread.sleep(Math.round(pause*pensCoefficient));
                    }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " choose the goods.");
    }


    @Override
    public void putGoodToBacket(String name, int count) {
        backet.putGood(name, count);
        System.out.println(this + " put goods " + name + " in count " + count);
    }

    @Override
    public void goToOut() {
        System.out.println(this + " go out.");
        int pause = Helper.random(100, 200);
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Override
    public String toString() {
        return this.getName();
    }

    public String getName() {
        return name;
    }
}
