package by.it.prymshyts.jd01_06;

import by.it.prymshyts.jd01_02.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    protected static String t1(String txt) {

        String[] lines = txt.split("\\n");
        int maxLengthOfLine = getMaxLengthOfLine(lines);
        StringBuilder[] formattedTxt = new StringBuilder[lines.length];

        for (int i = 0; i < formattedTxt.length; i++) {
            formattedTxt[i] = new StringBuilder(lines[i]);
        }

        for (StringBuilder line : formattedTxt) {
            int lengthDiff = maxLengthOfLine - line.length();
            Pattern pattern = Pattern.compile("\\s+");
            Matcher matcher = pattern.matcher(line);

            while (lengthDiff > 0) {
                if (matcher.find()) {
                    line.insert(matcher.end(), ' ');
                    matcher.find(); // Пропускаем пробел, который только что вставили.
                    lengthDiff--;
                } else {
                    matcher.reset();
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder line : formattedTxt) {
            result.append(new StringBuilder(line) + "\n");
        }

        return result.toString();
    }

    private static int getMaxLengthOfLine(String[] lines) {

        int maxLength = Integer.MIN_VALUE;

        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        return maxLength;
    }

    protected static void t2(String txt) {

        long firstFunc = t2_1(txt);
        long secondFunc = t2_2(txt);

        if (firstFunc > secondFunc) {
            System.out.println("StringBuilder быстрее String на " + (firstFunc - secondFunc) + " микросекунд.");
        } else {
            System.out.println("String быстрее StringBuilder на " + (secondFunc - firstFunc) + " микросекунд.");
        }

    }

    private static long t2_1(String txt) {

        String[] word = txt.split("[^а-яА-ЯёЁ]+");

        int firstWordIndex = 0;
        int lastWordIndex = word.length - 1;

        System.out.println("Создание строки из String.\nНачато...");


        String randomString = "";
        String randomWord;

        long startAt = System.currentTimeMillis() * 1000;

        while (randomString.length() < 1000000) {
            randomWord = word[Util.getRandomNum(firstWordIndex, lastWordIndex)];
            randomString += randomWord + " ";
        }

        if (randomString.length() > 1000000) {
            randomString = randomString.substring(0, 1000000);
        }

        long endAt = System.currentTimeMillis() * 1000;

        System.out.println("Время выполнения: " + (endAt - startAt) + " микросекунд.");

        return endAt - startAt;
    }

    private static long t2_2(String txt) {

        String[] word = txt.split("[^а-яА-ЯёЁ]+");

        int firstWordIndex = 0;
        int lastWordIndex = word.length - 1;

        System.out.println("Создание строки из StringBuilder.\nНачато...");


        StringBuilder randomString = new StringBuilder("");
        String randomWord;

        long startAt = System.currentTimeMillis() * 1000;

        while (randomString.length() <= 1000000) {
            randomWord = word[Util.getRandomNum(firstWordIndex, lastWordIndex)];
            randomString.append(randomWord + " ");
        }

        if (randomString.length() > 1000000) {
            randomString.delete(999999, randomString.length() - 1);
        }

        long endAt = System.currentTimeMillis() * 1000;

        System.out.println("Время выполнения: " + (endAt - startAt) + " микросекунд.");

        return endAt - startAt;
    }

    protected static String t3(String txt) {

        String[] words = sortWords(txt.split("[^а-яА-ЯёЁ]+"));
        StringBuilder resultString = new StringBuilder("");

        for (int i = 0; i < words.length - 1; i++) {
            if (!words[i].equals("")) {
                Integer wordCount = 0;

                resultString.append(words[i]);

                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].compareToIgnoreCase(words[j]) == 0) {
                        wordCount++;
                        words[j] = "";
                    }
                }

                if (wordCount > 0) {
                    resultString.append(" (" + wordCount.toString() + ")\n");
                } else {
                    resultString.append("\n");
                }
            }
        }

        return resultString.toString();
    }

    private static String[] sortWords(String[] words) {

        boolean swap;
        int first = words.length - 1;

        do {
            swap = false;

            for (int i = 0; i < first; i++) {
                if (words[i].length() < words[i + 1].length() ||
                        (words[i].length() == words[i + 1].length() &&
                                getVowelCount(words[i]) < getVowelCount(words[i + 1]))) {
                    String buffer = words[i];
                    words[i] = words[i + 1];
                    words[i + 1] = buffer;
                    swap = true;
                }
            }

            first--;
        } while (swap);

        return words;
    }

    private static int getVowelCount(String word) {

        Pattern pattern = Pattern.compile("[аяоёуюиыэеАЯОЁУЮИЫЭУ]");
        Matcher matcher = pattern.matcher(word);

        int count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
