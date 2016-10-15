package by.it.dubatovka.jd02_03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= Manager.limitCashier; i++) {
            executor.execute(new Cashier(i));
        }

        while (!Manager.limitBuyers()) {
            Manager.sleep(1000);
            int counter = Rnd.fromTo(0, 2);
            for (int i = 0; i < counter; i++) {
                Manager.countBuyers++;
                if (Manager.countBuyers < Manager.limitBuyers + 1) {
                    int random = Rnd.fromTo(0, 4);      //примерно каждый четыертый пенсионер
                    if (random == 1) {
                        new Buyer(Manager.countBuyers, true);
                    } else {
                        new Buyer(Manager.countBuyers, false);
                    }
                }
            }
        }executor.shutdown();
    }
}
