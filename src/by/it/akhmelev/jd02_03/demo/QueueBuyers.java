package by.it.akhmelev.jd02_03.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueBuyers {
    //этот класс нужен, чтобы очередь была
    // а) отдельной сущностью в программе, с возможностью модификации
    // б) была видна из прочих классов
    // в) имела только те методы из классов Core, которые нужны приложению

    //экземпляр очереди. Приватный т.к. очередь одна-единственная
    private final static ConcurrentLinkedQueue queueBuyers=new ConcurrentLinkedQueue();

    //замена статического метода на экземплярный из ConcurrentLinkedQueue;
    public static boolean add(Buyer buyer) {
        return queueBuyers.add(buyer);
    }

    //замена статического метода на экземплярный из ConcurrentLinkedQueue;
    public static Buyer poll() {
        if (queueBuyers.isEmpty()) {
            return null;
        } else {
            return (Buyer) queueBuyers.poll();
        }
    }
}


