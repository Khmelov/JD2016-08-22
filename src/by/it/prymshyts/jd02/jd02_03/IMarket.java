package by.it.prymshyts.jd02.jd02_03;

interface IMarket {
    int WORKING_TIME = 10000;   // mils
    int CASHIERS_NUM = 5;
    int MAX_GOODS = 1000;
    int MAX_BUYERS = 100;

    void open();
    void close();
    void letBuyersEnter();
    MarketState getState();
    void workTick();
}
