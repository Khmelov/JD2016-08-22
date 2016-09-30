package by.it.akhmelev.jd02_03.demo;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner {
    public static void main(String[ ] args) {
        //открываем и "по-новому" запускаем пул из 2 касс (но сам пул рассчитан на 5)
        ExecutorService executor=Executors.newFixedThreadPool(5);
        executor.execute(new Cashier()); //это класс, реализующий Runnable
        executor.execute(new Cashier()); //это класс, реализующий Runnable

        //теперь "по старинке" запускаем покупателей
        while (!Dispatcher.planComplete()) {
            Helper.sleep(1000); //ожидание в 1 секунду
            int count= Helper.fromTo(0, 2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                 new Buyer();
                 if (Dispatcher.planComplete())
                     break;
            }
        }
        //завершениe сервиса касс (нельзя будет добавить новые)
        //однако сами кассы продолжают работу, т.к. они уже выполняются
        executor.shutdown();

    }
}
