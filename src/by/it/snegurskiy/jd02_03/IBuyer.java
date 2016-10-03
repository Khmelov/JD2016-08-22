package by.it.snegurskiy.jd02_03;

/**
 * Created by snegurskiy.nn on 26.09.2016.
 */
public interface IBuyer {

    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goToOut(); //отправился на выход(мгновенно)
    void waitService() throws InterruptedException; // стал в очередьи ожидает обслуживания
}
