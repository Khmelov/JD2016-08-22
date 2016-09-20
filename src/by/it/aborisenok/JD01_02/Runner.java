package by.it.aborisenok.JD01_02;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        //прочитаем линию значений с клавиатуры.
       // String  line = Util.getOneLine();
//        String  line = "111 22 343 123 67 4 33 22 834 66";
//        //получим массив чисел с которым будем работать:
//        int arr[] = Util.lineToIntArray(line);
//
//        //A.1 Найти самое короткое и самое длинное число.
//        //   Вывести найденные числа и их длину.
//        String max = Task1.getMax(arr);
//        System.out.println(max);
//        String min = Task1.getMin(arr);
//        System.out.println(min);
//
//        //A.2 Вывести на консоль те числа, длина которых меньше
//        //   (больше) средней.
//        double mean=Task1.mean(arr);
//        System.out.print("Числа меньше "+mean+" таковы: ");
//        for (int i:arr) {
//            if (i<mean) {
//                System.out.print(i+" ");
//            }
//        }
//        System.out.println();
//
//        //A.3 Найти число, состоящее только из различных цифр.
//        //Если таких чисел несколько, найти первое из них.
//        for (int i:arr) {
//            if (Task1.uniqueDigits(i)) {
//                System.out.print("Найдено число из разных цифр: "+i);
//                break; //больше ничего не ищем
//            }
//        }
//
//        System.out.println("-------------------Часть Б---------------------");

        //Б.1 Определить принадлежит ли значение k интервалу [m, n]
        TaskB.ifInterval();

        //Б.2  Вывести числа от 1 до k ввиде матрицы N x N слева на право и сверху вниз
        // (k выберите квадратом целого числа).

        //Б.3 Найти корни квадратного уравнения
       // Task2.quadraticEquation();
    }
}
