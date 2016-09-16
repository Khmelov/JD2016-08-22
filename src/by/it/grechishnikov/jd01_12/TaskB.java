package by.it.grechishnikov.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String text = "As its name states, EETS was begun as a 'club', and it retains certain features " +
            "of that even now. It has no physical location, or even office, no paid staff or editors, but books in the " +
            "Original Series are published in the first place to satisfy subscriptions paid by individuals or institutions. " +
            "This means that there is need for a regular sequence of new editions, normally one or two per year; achieving " +
            "that sequence can pose problems for the Editorial Secretary, who may have too few or too many texts ready for " +
            "publication at any one time. Details on a separate sheet explain how individual (but not institutional) members " +
            "can choose to take certain back volumes in place of the newly published volumes against their subscriptions. On " +
            "the same sheet are given details about the very advantageous discount available to individual members on all " +
            "back numbers. In 1970 a Supplementary Series was begun, a series which only appears occasionally (it currently " +
            "has 24 volumes within it); some of these are new editions of texts earlier appearing in the main series. Again " +
            "these volumes are available at publication and later at a substantial discount to members. All these advantages " +
            "can only be obtained through the Membership Secretary (the books are sent by post); they are not available through " +
            "bookshops, and such bookstores as carry EETS books have only a very limited selection of the many published.";

    static void start() {
//        taskB1();
        taskB2();
    }

    private static void taskB1() {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0123456789]+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            String word = matcher.group();
            if(map.containsKey(word)) {
                int count = map.get(word) + 1;
                map.remove(word);
                map.put(word, count);
            } else {
                map.put(word, 1);
            }
        }
        printMap(map);
    }

    private static void taskB2() {
        long start = System.nanoTime();
        int n = 100;
        processArray(n);
        System.out.println("Время работы через ArrayList = " + (System.nanoTime() - start) + " наносекунд.");
        start = System.nanoTime();
        processLinked(n);
        System.out.println("Время работы через LinkedList = " + (System.nanoTime() - start) + " наносекунд.");
    }

    private static void processArray(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        delete(list);
    }

    private static void processLinked(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            list.add(i);
        }
        delete(list);
    }

    private static void delete(List<Integer> list) {
        int count = 0;
        while (true) {
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                count++;
                iterator.next();
                if(count % 2 == 0) {
                    iterator.remove();
                    count = 0;
                }
                if(list.size() == 1) {
                    System.out.println("Оставшийся элемент: " + list.get(0));
                    return;
                }
            }
        }
    }

    static void printMap(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }
}
