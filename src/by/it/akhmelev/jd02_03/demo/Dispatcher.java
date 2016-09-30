package by.it.akhmelev.jd02_03.demo;

import java.util.concurrent.atomic.AtomicInteger;

//вспомогательный класс с общими для всех классов величинами и методами
//содержит множество ошибок, хотя и работает вроде бы как надо.
//Найдите и исправьте их.
public class Dispatcher {
    //сколько планируется покупателей
    private static final int planCount=5;

    //члены класса для начала обслуживания
    static int countBuyers=0; //общий счетчик покупателей
    static boolean planComplete() {   //метод определяющий выполнение плана
        return countBuyers>=planCount;
    }

    //члены класса для завершения обслуживания
    //общий счетчик обслуженных покупателей
    static int countCompleteBuyers=0;

    //метод определяющий конец обслуживания
    static boolean finish() {
        return countCompleteBuyers>=planCount;
    }

    //Подсказка. Это еще один вариант общего счетчика обслуженных покупателей
    static AtomicInteger acountCompleteBuyers=new AtomicInteger(0);




    static int countCashiers=0; //общий счетчик кассиров



}
