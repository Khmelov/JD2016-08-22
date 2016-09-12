package by.it.voronovich.JD01_02;

/**
 * Класс содержит тела методов, предназначенных для решения задач блока A
 *
 * @author Dmitry Voronovich
 * @version 1.0
 */

public class Task_A {

    /**
     * Метод предназначен для нахождения элемента массива
     * с самой короткой строковой длиной
     *
     * @param arrStr строковый массив
     * @return возращает результат в метод в виде строки
     */
    protected static String getMin(String arrStr[]) {
        Integer min = Integer.MAX_VALUE;
        String h = null;
        int i = 0;
        do{
            if (min > arrStr[i].length()) {
                min = arrStr[i].length();
                h = arrStr[i];
            }
            i++;
        }
        while (i<arrStr.length);
        return "Самое короткое число: " + h + ", длинной " + min.toString() + " символ(ов)";
    }

    /**
     * Метод предназначен для нахождения элемента массива
     * с самой большой строковой длиной
     *
     * @param arrStr строковый массив
     * @return возращает результат в метод в виде строки
     */
    protected static String getMax(String arrStr[]) {
        Integer max = Integer.MIN_VALUE;
        String h = null;
        for (int i = 0; i < arrStr.length; i++) {
            if (max < arrStr[i].length()) {
                max = arrStr[i].length();
                h = arrStr[i];
            }
        }
        return "Самое длинное число: " + h + ", длинной " + max.toString() + " символ(ов)";
    }

    /**
     * Метод предназначен для нахождения среднего арифметического элементов массива
     *
     * @param arr числовой массив
     * @return возращает значение среднее арифметическое в метод
     */
    protected static double mean(int arr[]) {
        double result = 0;
        for (int i : arr) {
            result += i;
        }
        result = result / arr.length;
        return result;
    }

    /**
     * Метод предназначен для нахождения числа, состоящего
     * их рахных цифр
     *
     * @param value - строковый элемент массива
     * @return возвращает логическое значение
     */
    protected static boolean getUniqueDigit(String value) {
        char ch[] = value.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
