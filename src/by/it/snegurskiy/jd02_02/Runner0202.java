package by.it.snegurskiy.jd02_02;

/**
 * Created by snegurskiy.nn on 02.10.2016.
 */
public class Runner0202 {
    static int countBuyer = 0;
    static int countBuyers = 0;
    volatile static int countCashiers = 0;

    public static void main(String[] args)  {

        while (countBuyer<10)
            try {
                Thread.sleep(1000);
                int n = TimeHelper.random(0, 2);
                for (int i = 0; i < n; i++) {
                    new Buyer(countBuyer);
                    countBuyer++;
                    countBuyers++;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
