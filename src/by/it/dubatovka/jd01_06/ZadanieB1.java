package by.it.dubatovka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 14.09.2016.
 */
public class ZadanieB1 {

   public static  void soglasnaya(String data) {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}]");
        StringBuilder res = new StringBuilder(RuslanLudmila.dubzelenij);
        Matcher m = p.matcher(res);
        String soglas = "йцкнгшщзхфвпрлджчсмтб";
        soglas += soglas.toUpperCase();

        while (m.find()) {
            String slovo = m.group();
            System.out.println(m.group());
            if (5 == slovo.length()) {

                for (int i = 0; i < soglas.length() - 1; i++) {
                    if (slovo.charAt(0) == soglas.charAt(i)) {
                        res=res.delete(res.indexOf(slovo), res.indexOf(slovo) + 5);
                        System.out.println(soglas.charAt(i));
                        break;
                    }
                }
            }
        }


       System.out.println(res);
    }
}