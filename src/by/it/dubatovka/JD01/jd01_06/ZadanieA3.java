package by.it.dubatovka.JD01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 13.09.2016.
 */
public class ZadanieA3 {

    static boolean glasnaya(String word) {


        String glasnie = "яыуаиеоюэё";
        glasnie = glasnie + glasnie.toUpperCase();
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return (glasnie.indexOf(first) >= 0 && glasnie.indexOf(last) >= 0);
    }


    public static void poiskSlov(String s) {
        System.out.println("\n//Задание А3. Посчитать слова, начинающиеся и заканчивающиеся на глассную");
        StringBuilder text = new StringBuilder(s);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(text);
        int counter = 0;
        while (m.find())
            if (glasnaya(m.group()))
            {
                counter++;
                System.out.println(m.group());
            }

        System.out.println(counter);
    }

}
