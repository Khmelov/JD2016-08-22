package by.it.aborisenok.JD01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Лёша on 05.09.2016.
 */
public class Util {
    //чтение одной строки с консоли
   public static String getOneLine() throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String line = reader.readLine();
        return line;
    }

    //преобразование одной строки в массив чисел
   public static int[] lineToIntArray(String line){
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

    //чтение одного числа из консоли и преобразование его в int
    public static int lineToInt() throws IOException {
        String line = getOneLine();
        int number = Integer.parseInt(line);
        return number;
    }
}
