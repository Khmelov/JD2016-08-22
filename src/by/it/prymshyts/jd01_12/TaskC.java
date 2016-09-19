package by.it.prymshyts.jd01_12;

import by.it.prymshyts.jd01_02.Util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    static void t1() {
        String[] txt = Data.c1Txt.split("[\\n]+");
        TreeMap<String, String> map = new TreeMap<>();

        for (String str : txt) {
            map.put(generateCipher(), str);
        }

        System.out.println("Изначальный список:");
        System.out.println(map);

        HashSet<String> set = new HashSet<>();

        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();

            if (!set.add(entry.getValue())) {
                it.remove();
            }
        }

        System.out.println("Список без дубликатов:");
        System.out.println(map);
    }

    private static String generateCipher() {
        StringBuilder sb = new StringBuilder();

        sb.append(Util.getRandomNum(0, 9));
        sb.append(Util.getRandomNum(0, 9));
        sb.append(Util.getRandomNum(0, 9));

        return sb.toString();
    }

    static void t2() {
        System.out.println("Смотреть код класса MyCollect. Результат такой же как и в A2.");
    }

    /**
     * Метод можно использовать в матлабе для проверки на корректность введённой задачи.
     */

    static void t3() {
        HashMap<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[(]|[{]|[\\[]|[)]|[}]|[\\]]");
        Matcher matcher = pattern.matcher(Data.c3Txt);

        while (matcher.find()) {
            String c = matcher.group();

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("Текст: '" + Data.c3Txt + "'");

        boolean allOK = true;

        if (!checkBraces(map, "(", ")")) {
            allOK = false;
            System.out.println("Количество незакрытых скобок типа '()': " + getIncorrectNum(map, "(", ")"));
        }
        if (!checkBraces(map, "{", "}")) {
            allOK = false;
            System.out.println("Количество незакрытых скобок типа '{}': " + getIncorrectNum(map, "{", "}"));
        }
        if (!checkBraces(map, "[", "]")) {
            allOK = false;
            System.out.println("Количество незакрытых скобок типа '[]': " + getIncorrectNum(map, "[", "]"));
        }

        if (allOK) {
            System.out.println("Все скобки открыты/закрыты корректно.");
        }
    }

    private static boolean checkBraces(HashMap<String, Integer> map, String braceOpen, String braceClose) {
        if (map.get(braceOpen).equals(map.get(braceClose))) {
            return true;
        }
        return false;
    }

    private static int getIncorrectNum(HashMap<String, Integer> map, String braceOpen, String braceClose) {
        return Math.abs(map.get(braceOpen) - map.get(braceClose));
    }
}
