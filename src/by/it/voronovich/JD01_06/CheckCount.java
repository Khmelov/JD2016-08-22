package by.it.voronovich.JD01_06;

/**
 * Класс предназначен для нахождения количества вхождений подстроки в строку
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class CheckCount {

    /**
     * Метод вычисляет количествово вхождений элемента в строке
     *
     * @param str строка для поиска
     * @param line элемент вхождения
     * @return количество вхождений
     */
    public static int checkCounter(String str, String line) {
        return (str+ "\0").split(line).length - 1;
    }
}
