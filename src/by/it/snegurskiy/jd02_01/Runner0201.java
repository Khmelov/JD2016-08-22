package by.it.snegurskiy.jd02_01;

/**
 * Created by snegurskiy.nn on 01.10.2016.
 */
public class Runner0201 {

    static int countBuyer = 0;

    public static void main(String[] args)  {

        while (countBuyer<10)
        try {
            Thread.sleep(1000);
            int n = TimeHelper.random(0, 2);
            for (int i = 0; i < n; i++) {
                new Buyer(countBuyer);
                countBuyer++;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
