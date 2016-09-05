package by.it.prymshyts.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {

    protected static String t1(String txt) {

        StringBuilder tmp = new StringBuilder(txt);
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        Matcher matcher = pattern.matcher(tmp);

        while (matcher.find()) {
            tmp.setCharAt(matcher.start() + 4, '#');

            if (matcher.group().length() > 6) {
                tmp.setCharAt(matcher.start() + 6, '#');
            }
        }

        return tmp.toString();
    }

    protected static void t2(String txt) {

        String[] words = txt.split("[^а-яА-ЯёЁ]+");

        for (int i = 0; i < words.length; i++) {
            int count = 1;

            if (words[i].length() != 0) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        words[j] = "";
                    }
                }
                System.out.println("Слово " +  words[i].toLowerCase() + " встречается " + count + " раз.");
            }
        }
    }

    protected static void t3(String txt) {

        String[] words = txt.split("[^а-яА-ЯёЁ]+");
        Pattern pattern = Pattern.compile("^[аяоёуюиыэеАЯОЁУЮИЫЭУ].*([аяоёуюиыэеАЯОЁУЮИЫЭУ]$)+");  // Паттерн для поиска "полноценных" слов, исключая "а", "я", "у" и т.д.
        Matcher matcher;
        int count = 0;

        for (String word : words) {
            matcher = pattern.matcher(word);

            if (matcher.matches()) {
                count++;
            }
        }

        System.out.println("Количество слов, начинающихся и заканчивающихся на гласную: " + count);
    }
}


