package by.it.dubatovka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Dubatovka Sergey on 21.09.2016.
 */
public class Task_A1 {

    public static void positiveMarks() {

        List<Integer> positiveJournal = randomMarks(20);
        Iterator<Integer> iterator = positiveJournal.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() <= 2) iterator.remove();
        }

        System.out.println("Журнал удовлетворительных оценок: "+positiveJournal);
    }



    public static List<Integer> randomMarks(int numbers) {
        System.out.println("A1. Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками. \n " +
                "Удалить   неудовлетворительные оценки из списка. Вывести на консоль оба варианта" );


        List<Integer> journal = new ArrayList<>(numbers);
        Random random = new Random();

        int i = 0;
        while (i < numbers) {
            journal.add(random.nextInt(10) + 1);
            i++;
        }
        System.out.println("Журнал оценок: " + journal);
        return journal;
    }
}
