package by.it.snegurskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by snegurskiy.nn on 06.09.2016.
 */
public class B6 {

    public static boolean glasnaya(String word) {
        String glasnie="уеёыиаоэяюУЕЁЫАОЭЯИЮ";
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return  (glasnie.indexOf(first)>=0&&glasnie.indexOf(last)>=0);

    }
    public static String b1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("[^а-яА-Я][уеёыиаоэяюУЕЁЫАОЭЯИЮ]{1}[а-яёА-ЯЁ]{4}[^а-яА-Я]");
        Matcher m = p.matcher(tmp);
        while (m.find()) {
            System.out.println(m);
            int i=Math.min(m.start()+4,tmp.length()-1);
            tmp.delete(m.start(),i);

        }
        return tmp.toString();
    }

}
