package by.it.dubatovka.jd01_02;

public class TaskA {
    public static String maxLength(String arrStr[]) {
        String result = " ";
        int max = 0;
        for (String s : arrStr) {
            if (s.length() > max) {
                result = s;
                max = s.length();
            }
        }
        return result;
    }

    public static String minLength(String arrStr[]) {
        String result = " ";
        int min = Integer.MAX_VALUE;
        for (String s : arrStr) {
            if (s.length() < min) {
                result = s;
                min = s.length();
            }
        }
        return result;
    }

    public static double mean(int array[]) {
        double result = 0;
        for (int i : array) result += i;
        result = result / array.length;
        return result;

    }

    public static boolean uniqe(Integer value) {
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++)
                if (ch[i] == ch[j]) return false;

        return true;
    }
}



