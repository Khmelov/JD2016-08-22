package by.it.aborisenok.JD02_03;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Лёша on 26.09.2016.
 */
public class Runner {
   static int countSeconds = 0;
   static int countBuyers = 0;
   volatile static int countCashiers = 0;
    public static void main(String[] args) throws InterruptedException {
//
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            executor.execute(new Buyer(i+1));
        }

        while (!Dispatcher.planComplete()) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count=Helper.random(0,2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                countBuyers = Dispatcher.countBuyers++;
                    new Thread(new Buyer(countBuyers)).start();

            }
        }
        executor.shutdown();
//        while (countSeconds++ < 59) {
//                    System.out.println("***"+countSeconds+"***");
//
//                    try {
//                        Thread.sleep(1000);
//
//                        if (countSeconds%30 == countSeconds%60){
//                            System.out.println("+");
//                            if (countBuyers <= countSeconds + 10){
//                                int n = Helper.random(0, 2);
//                                for (int i = 0; i < n; i++){
//                                    System.out.println("first variant");
//                                    new Thread(new Buyer(++countBuyers)).start();
//
//                                }
//                            }
//                        }
//
//                        if (countSeconds%30 < countSeconds%60){
//                    System.out.println("-");
//                    if (countBuyers <= 40+(30-countSeconds)){
//                        int n = Helper.random(2, 2);
//                        for (int i = 0; i < n; i++){
//                            System.out.println("second variant");
//                            new Thread(new Buyer(--countBuyers)).start();
//                        }
//                    }
//                }
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
