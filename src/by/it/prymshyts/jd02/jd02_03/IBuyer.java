package by.it.prymshyts.jd02.jd02_03;

interface IBuyer {
    void enterInMarket();
    void chooseGoods();
    void waitInQueue(Cashier cashier);
    Cashier findCashier();
    void goToExit();
    void enterTradeHole();
    void exitTradeHole();
}
