package by.it.akhmelev.jd02_01.demo;

import java.util.ArrayDeque;
import java.util.Queue;

class Runner {
    static int countBuyers=0; //общий счетчик покупателей
    public static void main(String[ ] args) throws InterruptedException {
        //создаем очередь для покупателей. Пока обычную.
        Queue<Buyer> queue=new ArrayDeque<>();
        while (countBuyers<10) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count=Rnd.fromTo(0,2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers<11)
                {
                    Buyer buyer=new Buyer(countBuyers);
                    queue.add(buyer);
                }

            }
        }
    }
}
