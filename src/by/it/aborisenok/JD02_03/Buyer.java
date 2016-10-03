package by.it.aborisenok.JD02_03;



/**
 * Created by Лёша on 26.09.2016.
 */
public class Buyer  implements IBuyer, IUseBacket, Runnable{

    Backet backet;
    private String name;
    boolean pensioneer = false;
    double pensCoefficient = 1.5;
    public boolean iWait=false;


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
        waitServise();
        goToOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market.");
        threadSleepPause(100, 200);
    }

    @Override
    public void takeBacket() {
        backet = new Backet();
        System.out.println(this + " take the backet.");
        threadSleepPause(100, 200);
    }

    @Override
    public void chooseGoods() {
        int count = Helper.random(1, 4);

            for (int i = 0; i < count; i++) {
                String keyGood = Helper.getKeyGood();
                putGoodToBacket(keyGood, (int)(Math.random()*10));
            }
        threadSleepPause(500, 2000);
        System.out.println(this + " choose the goods.");
    }


    @Override
    public void putGoodToBacket(String name, int count) {
        backet.putGood(name, count);
    }

    @Override
    public void waitServise() {
        synchronized (this) {

            System.out.println(this + "встал в очередь на кассу");
            Queues.add(this);

            iWait=true;
            while (iWait) try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this + "закончил оплату товаров в кассе");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + " go out.");
        threadSleepPause(100, 200);
    }

    public void threadSleepPause(int from, int to){
        try {
            int pause = Helper.random(from, to);
            if (!pensioneer){
                Thread.sleep(pause);
            } else {
                Thread.sleep(Math.round(pause*pensCoefficient));
            }
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}
