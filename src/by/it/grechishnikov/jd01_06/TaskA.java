package by.it.grechishnikov.jd01_06;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {

    public static void task() {
        a1();
        a2();
        a3();
    }

    private static void a1() {
        System.out.println("1. Замена 5 и 7 символов на #\n");
        StringBuilder text = new StringBuilder(Runner.text);
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");

        Matcher m = p.matcher(text);
        while(m.find()) {
            int start = m.start();
            int length = m.group().length();
            text.setCharAt(start+4, '#');
            if(length > 6) {
                text.setCharAt(start+6, '#');
            }
        }

        System.out.println(text + "\n");
    }

    private static void a2() {
        System.out.println("2. Подсчет повторов слов\n");
        HashMap<String, Integer> map = new HashMap<>();
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Runner.text);

        while(m.find()) {
            String tmp = m.group();
            if(!map.containsKey(tmp)) {
                map.put(tmp, 1);
            } else {
                int value = map.get(tmp) + 1;
                map.remove(tmp);
                map.put(tmp, value);
            }
        }

        for(Map.Entry<String, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        System.out.println("\n");
    }

    private static void a3() {
        System.out.println("3. Подсчет слов, начинающихся и заканчивающихся на глассную\n");
        int counter = 0;
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Runner.text);
        String pattern = "аэиоуыяеёюАЭИОУЫЯЕЁЮ";

        while(m.find()) {
            String word = m.group();
            String first = String.valueOf(word.charAt(0));
            String last = String.valueOf(word.charAt(word.length() - 1));
            if(pattern.contains(first) && pattern.contains(last)) {
                counter++;
                System.out.println(word);
            }
        }

        System.out.println("Количество слов, начинающихся и заканчивающихся на глассную = " + counter + "\n");
    }
}