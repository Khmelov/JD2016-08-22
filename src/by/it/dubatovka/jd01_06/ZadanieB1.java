package by.it.dubatovka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 14.09.2016.
 */
public class ZadanieB1 {

    public static void taskB_1(String data) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        StringBuilder text = new StringBuilder(data);
        Matcher m = p.matcher(text);
        String soglasnie = "йцкнгшщзхфвпрлджчсмтб";
        soglasnie += soglasnie.toUpperCase();

        while (m.find()) {
            String slovo = m.group();

            if (5 == slovo.length()) {
                int dlinaSoglasnih=soglasnie.length();

                for (int i = 0; i < dlinaSoglasnih; i++) {
                    char firstSymbol=slovo.charAt(0);
                    char soglasnijSymbol=soglasnie.charAt(i);

                    if (firstSymbol==soglasnijSymbol) {
                        int start=text.indexOf(slovo);
                        int end=text.indexOf(slovo) + 4;
                        text=text.delete(start, end);
                        break;
                    }
                }
            }
        }


        System.out.println(text);
    }
}