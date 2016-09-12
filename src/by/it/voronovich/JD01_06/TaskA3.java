package by.it.voronovich.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит тело метода для решения задачи 3 блока A
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskA3 {

    /**
     * Метод находит количество слов, начинающихся и заканчивающихся гласной буквой
     */
    public static void a3() {

        StringBuilder text=new StringBuilder(Data.lukomorie);
        Pattern p=Pattern.compile("[а-яА-ЯёЁ]+");

        Matcher m=p.matcher(text);
        int counter=0;
        while (m.find()) //пока находятся слова, мы подсчитываем число подходящих под проверку
            if (CheckVowel.Vowel(m.group()))
            {
                counter++;
                System.out.println(m.group());
            }
        System.out.print("Количество слов, начинающихся и заканчивающихся на гласную: " + counter);
    }
}
