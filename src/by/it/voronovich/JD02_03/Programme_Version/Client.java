package by.it.voronovich.JD02_03.Programme_Version;

import by.it.voronovich.JD02_03.Programme_Version.Interface.IClient;
import by.it.voronovich.JD02_03.Programme_Version.Interface.IUseBasket;
import by.it.voronovich.JD02_03.Programme_Version.Util.GoodsList;
import by.it.voronovich.JD02_03.Programme_Version.Util.PrintCheck;
import by.it.voronovich.JD02_03.Programme_Version.Util.RandomNum;
import static by.it.voronovich.JD02_03.Programme_Version.Util.Queue.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Класс реализует методы, свойственные объекту "Client"
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Client extends Thread implements IClient, IUseBasket {

    private double k = 1.5; // коэффициент скорости пенсионера
    private boolean retired; // переменная пенсионер
    private static Semaphore semaphoreChooseTen = new Semaphore(10);//семафор для ограничения количества выбирающих
    private static Semaphore semaphoreChooseTurn = new Semaphore(40);//семафор для ограничения количества стоящих в очереди
    public List<String> choosenGoods = new ArrayList<String>(); // список выбранных продуктов

    public Client(int number) {
        this.setName("Покупатель № " + number);
        if (number % 4 == 0) {
            retired = true;
            setPriority(MAX_PRIORITY); // задаем высокий приоритет выполнения потоков с пенсионерами-клиентами
        } else {
            retired = false;
            setPriority(MIN_PRIORITY);
        }
        start();
    }

    /**
     * В данном методе реализовали:
     * - используем "семафор'ы" для ограничения количества покупателей, одновременно выбирающих продукты и стоящих в очереди
     */
    @Override
    public void run() {
        enterMarket();
        //-------------------------------
        takeBasket();
        //-------------------------------
        try {
            semaphoreChooseTen.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreChooseTen.release();
        }
        //-------------------------------
        putGoodsIntoBasket();
        //-------------------------------
        try {
            semaphoreChooseTurn.acquire();
            takeATurn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreChooseTurn.release();
        }
        //--------------------------------
        exitMarket();
    }

    @Override
    public void enterMarket() {
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void takeBasket() {
        try {
            if (retired == true) {
                Thread.sleep((int) (RandomNum.Random(100, 200) * k));
            } else {
                Thread.sleep(RandomNum.Random(100, 200));
            }
            System.out.println(this + " взял корзинку для покупок.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * В данном методе реализовали:
     * - собираем в списки товары покупателей рандомно из общего списка товаров ConcurrentHashMap;
     * - увеличиваем время действий в 1,5 раза для пенсионеров
     */
    @Override
    public void chooseGoods() {
        try {
            int count = RandomNum.Random(1, 4);
            for (int i = 0; i < count; i++) {
                if (retired == true) {
                    Thread.sleep((int) (RandomNum.Random(500, 2000) * k));
                } else {
                    Thread.sleep(RandomNum.Random(500, 2000));
                }
                String goodsName = GoodsList.getGoods();
                choosenGoods.add(goodsName);
                System.out.println(this + " выбрал " + goodsName + " стоимостью " + GoodsList.getPrice(goodsName) + " рублей.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * В данном методе реализовали:
     * - увеличиваем время действий в 1,5 раза для пенсионеров
     */
    @Override
    public void putGoodsIntoBasket() {
        try {
            for (String cg : choosenGoods) {
                if (retired == true) {
                    Thread.sleep((int) (RandomNum.Random(100, 200) * k));
                } else {
                    Thread.sleep(RandomNum.Random(100, 200));
                }
                System.out.println(this + " положил " + cg + " в корзинку.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void takeATurn() {
        System.out.println(this + " занял очередь в кассу.");
        queue.addLast(this);
        synchronized (this) {
            try {
                System.out.println(this + " ожидает в очереди.");
                this.wait();
                PrintCheck.printCheckClient(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this + " закончил обслуживаться.");
            }
        }
    }

    @Override
    public void exitMarket() {
        System.out.println(this + " вышел из магазина.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

