package by.it.filimonchik.jd02_03;


import java.util.Set;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
class Buyer extends Thread implements IBuyer, IUseBasket{
    int num;
    public  boolean iWait=false;
    Basket basket;

    public Buyer() {
        num=++Dispatcher.countBuyers;
        this.setName("Buyer № " + num + " ");
        start();
    }

    @Override
    public void run() {
        goToMarket();
        takeShoppingCart();
        chooseItems();
        goToQueue();
        goToExit();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void goToMarket() {
    System.out.println(this + "entered to the market");
    }

    @Override
    public void chooseItems() {
//        int pause = Helper.fromTo(500, 2000);
//        Helper.sleep(pause);
//        System.out.println(this + "choose the item");
//
        int count = Helper.random(1, 4);
        try {
            for (int i = 0; i < count; i++) {
                int pause = Helper.fromTo(100, 200);
                Set<String> keyGoods = Helper.allPriceForGoods.keySet();
                int numberGood = Helper.random(0, keyGoods.size() - 1);
                String keyGood = (String) keyGoods.toArray()[numberGood];
                putItemsToBasket(keyGood, (float) Math.random()+10);
                sleep(pause);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void goToQueue() {
        synchronized (this){
            System.out.println(this + "go to queque");
            Queue.add(this);
            iWait=true;
            while (iWait)try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(this + "end to pay in cashier" );
        }

    }

    @Override
    public void goToExit() {
        System.out.println(this + "go to exit" );

    }

    @Override
    public void takeShoppingCart() {
        basket = new Basket();
        System.out.println(this + " take the basket");

    }

    @Override
    public void putItemsToBasket(String name, float count) {
        basket.putGood( name, count);
        System.out.println(this + " choose the item " + name + " in a count of " + count);

    }
}
