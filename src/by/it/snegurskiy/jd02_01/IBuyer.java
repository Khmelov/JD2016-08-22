package by.it.snegurskiy.jd02_01;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goToOut(); //отправился на выход(мгновенно)
}
