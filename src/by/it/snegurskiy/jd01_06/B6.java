package by.it.snegurskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by snegurskiy.nn on 06.09.2016.
 */
public class B6 {


    public static String b1(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("[^а-яА-Я][уеёыиаоэяюУЕЁЫАОЭЯИЮ]{1}[а-яёА-ЯЁ]{4}[^а-яА-Я]");
        Matcher m = p.matcher(tmp);
        int col=0;
        while (m.find()) {
           col++;
        }
        StringBuilder tmp1 = new StringBuilder(txt);
        Pattern p1 = Pattern.compile("[^а-яА-Я][уеёыиаоэяюУЕЁЫАОЭЯИЮ]{1}[а-яёА-ЯЁ]{4}[^а-яА-Я]");
        Matcher m1 = p.matcher(tmp1);
        for (int i = 0; i <col ; i++) {
        while (m1.find()) {
            tmp1.delete(m1.start(),m1.end()-1);
            break;
        }}
        return tmp1.toString();
    }

    public static String[] b2(String txt) {
        StringBuilder tmp = new StringBuilder(txt);
        Pattern p = Pattern.compile("\n");
        Matcher m = p.matcher(tmp);
        while (m.find()) {
            tmp.replace(m.start(),m.end()," ");
        }
        String[] sentence=(txt).toString().split("[.!?]");
        for (int i = 0; i <sentence.length-1 ; i++) {
            for (int j = i+1; j <sentence.length ; j++) {


            }

        }

        return sentence;
    }

}
