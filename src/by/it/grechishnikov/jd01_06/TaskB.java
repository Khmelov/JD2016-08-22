package by.it.grechishnikov.jd01_06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {
    static void task() {
        b1();

        b2();

        System.out.println("Введите символ:");
        String s = new Scanner(System.in).nextLine();
        char c = s.charAt(0);
        b3(c);
    }

    private static void b1() {
        System.out.println("1. Удалить слова длинны 5, которые начинаются на согласную\n");
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]{5,}");
        StringBuilder text = new StringBuilder(Runner.text);
        Matcher m = p.matcher(Runner.text);
        String pattern = "бвгджзклмнпрстфхцчшщъыь";
        pattern += pattern.toUpperCase();

        while(m.find()) {
            String word = m.group();
            if(word.length() == 5) {
                if(pattern.contains(String.valueOf(word.charAt(0)))) {
                    int start = text.indexOf(word);
                    text.delete(start, start + 5);
                }
            }
        }
        System.out.println(text + "\n");
    }

    private static void b2() {
        System.out.println("2. Вывести предложения в порядке возрастания количества слов в каждом. Убрать переносы строк\n");
        String text = Runner.text.replace("\n", "");
        Pattern p = Pattern.compile("([а-яА-ЯёЁ, ;:\\n-]+)([.]{2,3})*([.!])");
        Matcher m = p.matcher(text);
        TreeMap<Integer, String> map = new TreeMap<>();
        while(m.find()) {
            int count = 0;
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]");
            Matcher matcher = pattern.matcher(m.group());
            while(matcher.find()) {
                count++;
            }
            map.put(count, m.group().trim());
        }
        for(Map.Entry<Integer, String> pair: map.entrySet()) {
            System.out.println(pair.getValue());
        }
    }

    private static void b3(final char c) {
        System.out.println("Отсортировать слова по убыванию количества вхождения заданного символа, а в случае равенства - по алфовиту");
        System.out.println("Ищем символ \"" + c + "\"");
        Pattern p = Pattern.compile("([а-яА-ЯёЁ]+)");
        Matcher m = p.matcher(Runner.text);
        TreeSet<String> set = new TreeSet<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                //сравнение по первому признаку
                int firstCount = counter(s1, c);
                int secondCount = counter(s2, c);
                int result = secondCount - firstCount;
                if(result == 0) {
                    //сравнение по второму признаку
                    return s1.compareToIgnoreCase(s2);
                }
                return result;
            }
        });
        while(m.find()) {
            set.add(m.group());
        }
        for(String s : set) {
            System.out.println(s);
        }
    }

    private static int counter(String word, char c) {
        int result = 0;
        //поиск количества вхождения
        for(char s : word.toLowerCase().toCharArray()) {
            if(c == s) {
                result++;
            }
        }
        return result;
    }
}
