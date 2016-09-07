package by.it.prymshyts.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    protected static String t1(String txt) {

        String[] lines = txt.split("\\n");
        int maxLengthOfLine = getMaxLengthOfLine(lines);
        StringBuilder formattedTxt = new StringBuilder(txt);

        for (String line : lines) {
            int lengthDiff = maxLengthOfLine - line.length();
            Pattern pattern = Pattern.compile("\\s+");
            Matcher matcher = pattern.matcher(line);


            while (lengthDiff > 0) {
                if (matcher.find()) {
                    System.out.println(line);
                    System.out.println(matcher.end());
                    formattedTxt.insert(matcher.end(), ' ');
                    System.out.println(matcher.end());
                }
                lengthDiff--;
            }
        }

        return formattedTxt.toString();
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
}
