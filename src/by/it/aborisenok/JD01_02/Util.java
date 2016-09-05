package by.it.aborisenok.JD01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Лёша on 05.09.2016.
 */
public class Util {
    //чтение одной строки с консоли
    static String getOneLine() throws IOException {
        BufferedReader stin = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("type the text");
        String line = stin.readLine();
        stin.close();
        return line;
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
