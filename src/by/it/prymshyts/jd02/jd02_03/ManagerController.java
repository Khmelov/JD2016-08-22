package by.it.prymshyts.jd02.jd02_03;

class ManagerController extends Thread {

    private Market market = null;

    ManagerController(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        market.open();
        while (market.getState() == MarketState.OPENED) {
            market.letBuyersEnter();
            market.workTick();
            pause();
        }
        market.close();
    }

    static void pause() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println("Пауза установлена некорректно.");
        }
    }

    static void pause(int pauseTime) {
        try {
            Thread.sleep(pauseTime);
        } catch (Exception e) {
            System.err.println("Пауза установлена некорректно.");
        }
    }
}
