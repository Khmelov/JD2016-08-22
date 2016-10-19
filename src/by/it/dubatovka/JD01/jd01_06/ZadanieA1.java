package by.it.dubatovka.JD01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 12.09.2016.
 */
public class ZadanieA1 {
    public static void zamenaSimvolov5i7(String s) {
        System.out.println("//Задание А1. Замена 5 и 7 символов на #");

        StringBuilder data = new StringBuilder(s);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher m = p.matcher(data);
        while (m.find()) {
            int i = m.start();
            int dlinaSlova = m.group().length();
            data.setCharAt(i + 4, '#');
            if (dlinaSlova > 6) data.setCharAt(i + 6, '#');
        }
        System.out.println(data);

    }
}