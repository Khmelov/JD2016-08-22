package by.it.dubatovka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 14.09.2016.
 */
public class ZadanieB1 {

    public static void taskB_1(String data) {
        System.out.println("\n//Задание B1. Удалить слова длинны 5, которые начинаются на согласную");
        System.out.println("");
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        StringBuilder text = new StringBuilder(data);
        Matcher m = p.matcher(text);
        String soglasnie = "йцкнгшщзхфвпрлджчсмтб";
        soglasnie += soglasnie.toUpperCase();

        while (m.find()) {
            String word = m.group();
            if (5 == word.length()) {

                for (int i = 0; i < soglasnie.length(); i++) {
                    if (word.charAt(0) == soglasnie.charAt(i)) {
                        text = text.delete(m.start(), m.end());
                        m.reset();
                        break;
                    }
                }
            }
        }
        System.out.println(text);
    }
}