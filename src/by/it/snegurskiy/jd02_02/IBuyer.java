package by.it.snegurskiy.jd02_02;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goToOut(); //отправился на выход(мгновенно)
    void takeBasket(); //взял корзину
    void putGoodsToBasket(); //положил выбранный товар в корзину
    void waitService();     //встал в очередь и ожидает обслуживание
}
