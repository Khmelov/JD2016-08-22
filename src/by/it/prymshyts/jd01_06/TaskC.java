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
            result.append(line + "\n");
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

        String[] word = txt.split("[^а-яА-ЯёЁ]+");

        int firstWordIndex = 0;
        int lastWordIndex = word.length - 1;

        StringBuilder randomString = new StringBuilder("");
        String randomWord;

        while (randomString.length() <= 1000000) {
            System.out.println("...");
            randomWord = word[Util.getRandomNum(firstWordIndex, lastWordIndex)];

            //if ((randomString.length() + randomWord.length() + 1) > 1000000) {
            //    continue;
            //}

            randomString.append(randomWord + " ");
        }

        System.out.println(randomString);
        System.out.println(randomString.length());
    }
}
