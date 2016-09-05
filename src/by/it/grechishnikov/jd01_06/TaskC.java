package by.it.grechishnikov.jd01_06;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC {
    private static ArrayList<String> words = new ArrayList<>();

    static {
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher m = p.matcher(Runner.text);

        while(m.find()) {
            words.add(m.group());
        }
    }

    static void task() {
        System.out.println("TaskC - 2");
        long first = c2(false);
        long last = c2(true);
        System.out.println("Время выполнения через String = " + first + " милисек.");
        System.out.println("Время выполнения через StringBuilder = " + last + " милисек.");
        System.out.printf("StringBuilder быстрее в %.2f раз.\n\n", ((double) first / last));

        System.out.println("TaskC - 3");
        c3();
    }

    private static long c2(boolean useStribBuilder) {
        long start = System.currentTimeMillis();
        System.out.println("Собираем строку на миллион символов через " + (useStribBuilder? "StringBuilder" : "String"));

        return useStribBuilder ? find(words, true) - start : find(words) - start;
    }

    private static long find(List<String> words) {
        int barier = 1_000_000;
        String line = "";
        while(true) {
            int index = ThreadLocalRandom.current().nextInt(0, words.size());
            String word = words.get(index);
            if (word.length() + line.length() + 1 <= barier) {
                line += word + " ";
            } else if(word.length() + line.length() == barier) {
                line += word;
            }
            if (line.length() == barier) {
                break;
            }
        }
        System.out.println("Final line size = " + line.length());
        return System.currentTimeMillis();
    }

    private static long find(List<String> words, boolean useStribBuilder) {
        int barier = 1_000_000;
        StringBuilder line = new StringBuilder();
        while(true) {
            int index = ThreadLocalRandom.current().nextInt(0, words.size());
            StringBuilder word = new StringBuilder(words.get(index));
            if (word.length() + line.length() + 1 <= barier) {
                line.append(word).append(" ");
            } else if(word.length() + line.length() == barier) {
                line.append(word);
            }
            if (line.length() == barier) {
                break;
            }
        }
        System.out.println("Final line size = " + line.length());
        return System.currentTimeMillis();
    }

    private static void c3() {
        System.out.println("Сортировка и подсчет...");
        Map<String, Integer> map = initMap();
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
    }
    private static Map<String, Integer> initMap() {
        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
                StringBuilder b = new StringBuilder(s2); //для задания contentEquals
                if(s1.contentEquals(b)) {
                    return 0;
                }
                int first = s1.length();
                int second = s2.length();
                if(first != second) {
                    return second - first;
                } else {
                    String pattern = "аоуэыяёюеи";
                    first = 0;
                    for(char c : s1.toLowerCase().toCharArray()) {
                        if(pattern.contains(String.valueOf(c))) {
                            first++;
                        }
                    }
                    second = 0;
                    for(char c : s2.toLowerCase().toCharArray()) {
                        if(pattern.contains(String.valueOf(c))) {
                            second++;
                        }
                    }
                    if(first - second == 0) {
                        return s1.compareToIgnoreCase(s2);
                    }
                    return first - second;
                }
            }
        });
        for(String word : words) {
            word = word.toLowerCase();
            boolean flag = false;
            for(Map.Entry<String, Integer> pair : map.entrySet()) {
                String tmp = pair.getKey();
                if(word.equalsIgnoreCase(tmp)) {
                    flag = true;
                }
            }
            if(!flag) {
                map.put(word, 1);
            } else {
                int count = 1;
                ArrayList<String> forRemove = new ArrayList<>();
                for(Map.Entry<String, Integer> pair : map.entrySet()) {
                    String tmp = pair.getKey();
                    if (word.equalsIgnoreCase(tmp)) {
                        count += pair.getValue();
                        forRemove.add(pair.getKey());
                    }
                }
                for(String s : forRemove) {
                    map.remove(s);
                }
                map.put(word, count);
            }
        }
        return map;
    }
}