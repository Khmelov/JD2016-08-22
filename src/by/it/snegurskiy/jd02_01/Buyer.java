package by.it.snegurskiy.jd02_01;

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
            System.out.println(this + " вышел в магазин");

        }

        @Override
        public void run () {
            enterToMarket(); //вошел в магазин (мгновенно)
            takeBacket(); //взял корзину
            chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
            putGoodsToBacket(); //положил выбранный товар в корзину
            goToOut(); //отправился на выход(мгновенно)


        }

        @Override
        public String toString () {
            return this.getName();
        }

        @Override
        public void takeBacket () {
            System.out.println(this + " взял корзинку");
        }

        @Override
        public void putGoodsToBacket () {
            System.out.println(this + " положил товар в корзинку");
        }
    }
