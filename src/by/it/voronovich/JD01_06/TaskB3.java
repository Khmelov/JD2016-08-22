package by.it.voronovich.JD01_06;

import java.util.Arrays;

/**
 * Класс содержит тело метода для решения задачи 1 блока B
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskB3 {

    /**
     * Метод решает проблему сортировки по количеству
     * вхождений элемента в словах с учетом алфавитного порядка
     *
     * @param line элемент вхождения
     */
    protected static void b3(String line) {

        String[] words = Data.lukomorie.split("[^а-яА-ЯЁё]+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                int a = CheckCount.checkCounter(words[j], line);
                int b = CheckCount.checkCounter(words[j + 1], line);
                if (a < b) {
                    String strr = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = strr;
                }
            }
        }
        System.out.println("Результат сортировки с элементом вхождения " + line + " :");
        int count = 1;
        for (String word : words) {
            System.out.println(count + ")" + (word));
            count++;
        }
    }
}
