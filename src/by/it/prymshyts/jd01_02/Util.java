package by.it.prymshyts.jd01_02;

import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);

    protected static int getConsoleNumber() {

        return scanner.nextInt();
    }

    protected static String getConsoleLine() {

        return scanner.nextLine();
    }

    protected static int[] stringToIntArr(String line) {

        String[] strArr = line.split(" ");
        int[] intArr = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        return intArr;
    }

    protected static double getMean(int[] arr) {

        double result = 0;

        for (int i : arr) {
            result += i;
        }
        result /= arr.length;

        return result;
    }

    protected static boolean checkForUniqueDigits(Integer value) {

        if (value.toString().length() < 2)
            return false;

        char[] numberArr = value.toString().toCharArray();

        for (int i = 0; i < numberArr.length; i++) {
            for (int j = i + 1; j < numberArr.length; j++) {
                if (numberArr[i] == numberArr[j])
                    return false;
            }
        }

        return true;
    }

    protected static int getRandomNum(int min, int max) {

        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
