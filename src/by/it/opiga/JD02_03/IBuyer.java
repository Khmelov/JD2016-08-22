package by.it.opiga.JD02_03;

public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void waitService();
    void goToOut(); //отправился на выход(мгновенно)
}
