package by.it.akhmelev.jd01_02;

import java.io.IOException;

/**
 * Пример выполнения задания А
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        //прочитаем линию значений с клавиатуры.
        String  line=Util.getOneLine();
        //String  line="11 22 343 123 67 456 333 22 853 -999";
        //получим массив чисел с которым будем работать:
        int arr[]=Util.lineToIntArray(line);
        //1. Найти самое короткое и самое длинное число.
        //   Вывести найденные числа и их длину.
        String max=TaskA.getMax(arr);
        System.out.println(max);
        String min=TaskA.getMin(arr);
        System.out.println(min);

        //2. Вывести на консоль те числа, длина которых меньше
        //   (больше) средней.
        double mean=TaskA.mean(arr);
        System.out.print("Числа меньше "+mean+" таковы: ");
        for (int i:arr) {
            if (i<mean) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        //3. Найти число, состоящее только из различных цифр.
        //Если таких чисел несколько, найти первое из них.
        for (int i:arr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Найдено число из разных цифр: "+i);
                break; //больше ничего не ищем
            }
        }


    }

}












