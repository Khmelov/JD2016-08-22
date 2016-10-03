package by.it.voronovich.JD02_03.Programme_Version.Interface;

/**
 * Интерфейс реализует основные методы покупателей
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public interface IClient {

    /**
     * войти в магазин
     */
    void enterMarket();

    /**
     * выбрать товары
     */
    void chooseGoods();

    /**
     * занять очередь
     */
    void takeATurn();

    /**
     * выйти из магазина
     */
    void exitMarket();
}
