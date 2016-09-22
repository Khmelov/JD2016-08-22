package by.it.dubatovka.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dubatovka Sergey on 22.09.2016.
 */
public class Task_B1 {

    public static void taskb1(String text) {

        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(text);
        Map<String, Integer> wordCount = new HashMap<>();
        System.out.println(text);
        while (m.find()) {
            String word = m.group();
            if (wordCount.get(word) == null) {
                wordCount.put(word, 1);
            } else {
                Integer count = wordCount.get(word);
                wordCount.put(word, ++count);
            }
        }
        System.out.println(wordCount);
    }
}
