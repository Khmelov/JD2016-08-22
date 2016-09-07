package by.it.voronovich.JD01_06;

import by.it.akhmelev.jd01_06.Level_A.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит тело метода для решения задачи 1 блока A
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class TaskA1 {

    /**
     * Метод заменяет 5-ю и 7-ю ьуквы символом #
     */
    protected static void a1() {

        StringBuilder text = new StringBuilder(Data.lukomorie);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");

        Matcher m = p.matcher(text);
        while (m.find()) {
            int start = m.start();
            int length = m.group().length();
            text.setCharAt(start + 4, '#');
            if (length > 6)
                text.setCharAt(start + 6, '#');
        }
        System.out.print(text);
    }

}
