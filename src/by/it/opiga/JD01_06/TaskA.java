package by.it.opiga.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 02.09.2016.
 */
public class TaskA {
    static String z1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("[а-яФ-ЯёЁ]{5,}");
        Matcher m = p.matcher(tmp);
        while (m.find()) {
            System.out.println(m.start() + " " + m.group());
            tmp.setCharAt(m.start() + 4, '#');
            if(m.group().length()>6)
                tmp.setCharAt(m.start()+6,'#');
        }
        return tmp.toString();
    }

    static void z2(String txt) {
        String[] words = txt.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < words.length; i++) {
            int count = 1;
            if (!words[i].isEmpty()) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        words[j] = "";
                    }

                }
                System.out.println(words[i] + ":" + count);
            }

        }
    }

    static void z3(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        String[] words = txt.split("[^а-яА-ЯёЁ]+");
        int count = 0;
        Pattern p = Pattern.compile("^[уеэоаяиюёЁУЕЭОАЯИЮ].*[уеэоаяиюёЁУЕЭОАЯИЮ]$");

        for (int i = 0; i < words.length; i++) {
            Matcher m = p.matcher(words[i]);
            if (m.find()) {
                count++;
                System.out.println(m.group());
                }
            }
        System.out.println("количество слов начинающихся и заканчивающихся гласной = "+count);
        }
}