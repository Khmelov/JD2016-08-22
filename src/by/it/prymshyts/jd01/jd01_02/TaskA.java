package by.it.prymshyts.jd01.jd01_02;

public class TaskA {

    protected static String getLongestNum(String line) {

        String longestNum = "";
        int maxLen = Integer.MIN_VALUE;
        String[] strArr = line.split(" ");

        for (String word : strArr) {
            if (word.length() > maxLen) {
                longestNum = word;
                maxLen = word.length();
            }
        }

        return longestNum;
    }

    protected static  String getShortestNum(String line) {

        String shortestNum = "";
        int minLen = Integer.MAX_VALUE;
        String[] strArr = line.split(" ");

        for (String word : strArr) {
            if (word.length() < minLen) {
                shortestNum = word;
                minLen = word.length();
            }
        }

        return shortestNum;
    }

    protected static void printShorterThanMean(String line, double meanNum) {

        String[] strArr = line.split(" ");
        String mean = Double.toString(Math.round(meanNum));

        System.out.println("Числа короче, чем " + mean + ":");
        for (String word : strArr) {
            if (word.length() < mean.length()) {
                System.out.println(" " + word);
            }
        }
    }

    protected static void printUniqueDigitsNumber(int[] arr) {

        for (int i : arr) {
            if (Util.checkForUniqueDigits(i)) {
                System.out.println("Найдено число из разных цифр: " + i);
                return;
            }
        }

        System.out.println("Числа с уникальными цифрами не найдено");
    }
}
