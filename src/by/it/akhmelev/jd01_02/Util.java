package by.it.akhmelev.jd01_02;

import java.io.IOException;
import java.util.Scanner;

/**
 * Утилиты ввода, вывода и преобразований
 */
class Util {
    //чтение одной строки с консоли
    static String getOneLine() throws IOException {
        return new Scanner(System.in).nextLine();
    }

    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line){
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив чисел
        int[] array = new int[strArray.length];
        for(int j = 0; j < strArray.length; j++)
        {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }


}
