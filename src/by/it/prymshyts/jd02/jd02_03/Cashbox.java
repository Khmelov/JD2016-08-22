package by.it.prymshyts.jd02.jd02_03;

import by.it.prymshyts.jd01.jd01_02.Util;

@SuppressWarnings("all")
class Cashbox {
    void handleBuyer(Buyer buyer) {
        ManagerController.pause(Util.getRandomNum(2000, 5000));
        synchronized (buyer) {
            buyer.notify();
        }
    }
}
