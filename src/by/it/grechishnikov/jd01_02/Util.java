package by.it.grechishnikov.jd01_02;

import java.util.Scanner;

/**
 * Created by Evgeniy on 24.08.16.
 */
public class Util {
    /*1 сканнер на весь клас, т.к. при закрытии его и создании нового
    кидается исключение. Приватный - что бы его больше никто не мог
    использовать, кроме статических методов данного класса*/
    private static Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        //Получаем строку с клавиатуры
        return scanner.nextLine();
    }

    public static int getInt() {
        //Получаем число
        while(true) {
            String s = scanner.nextLine();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Ошибка");
            }
        }
    }

    public static int[] getIntArr(String[] arr) {
        //Преобразуем строчный массив в числовой
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}
