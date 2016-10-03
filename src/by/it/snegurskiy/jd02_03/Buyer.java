package by.it.snegurskiy.jd02_03;

/**
 * Created by snegurskiy.nn on 26.09.2016.
 */
public class Buyer extends Thread implements IBuyer,IUseBasket {

    int number;

    public Buyer(Integer number) {
        super("Покупатель №" + number.toString());
        this.number = number;
        start();

    }

        @Override
        public void enterToMarket () {

            System.out.println(this + " зашел в магазин");

        }

        @Override
        public void chooseGoods () {
            int pause=TimeHelper.random(500,2000);
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this + " выбрал товар");
        }

        @Override
        public void goToOut () {

            System.out.println(this + " вышел из магазина");


        }

    @Override
    public void waitService(){
        synchronized (QueueBuyer.buyers) {
            QueueBuyer.buyers.addLast(this);
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
        public void run () {
            enterToMarket(); //вошел в магазин (мгновенно)
            takeBasket(); //взял корзину
            chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
            putGoodsToBasket(); //положил выбранный товар в корзину
            waitService();// стал в очередь и ожидает обслуживания
            goToOut(); //отправился на выход(мгновенно)


        }

        @Override
        public String toString () {
            return this.getName();
        }

        @Override
        public void takeBasket () {
            int pause=TimeHelper.random(100,200);
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this + " взял корзинку");
        }

        @Override
        public void putGoodsToBasket () {



            int pause=TimeHelper.random(100,200);
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }System.out.println(this + " положил товар в корзинку");
            //HashMap<String,Integer> Basket=new HashMap<>();
            System.out.println(this + " положил товар в корзинку");
        }
    }
