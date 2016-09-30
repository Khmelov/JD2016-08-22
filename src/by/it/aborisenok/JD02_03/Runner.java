package by.it.aborisenok.JD02_03;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Лёша on 26.09.2016.
 */
public class Runner {
   static int countSeconds = 0;
   static int countBuyers = 0;
   volatile static int countCashiers = 0;
    public static void main(String[] args) throws InterruptedException {
//

        while (countBuyers<10) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count=Helper.random(0,2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers<31)
                {
                    new Thread(new Buyer(countBuyers)).start();
                }
            }
        }

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
