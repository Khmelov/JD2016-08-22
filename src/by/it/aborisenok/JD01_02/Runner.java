package by.it.aborisenok.JD01_02;

import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException, InterruptedException {

            //прочитаем линию значений с клавиатуры.
            System.out.println("Введите с клавиатуры сроку цифр");
            String line = Util.getOneLine();
            //String  line = "111 22 343 123 67 4 33 22 834 66"; //для теста
            //получим массив чисел с которым будем работать:
            int arr[] = Util.lineToIntArray(line);

            //A.1 Найти самое короткое и самое длинное число.
            //   Вывести найденные числа и их длину.
            String max = TaskA.getMax(arr);
            System.out.println(max);
            String min = TaskA.getMin(arr);
            System.out.println(min);

            //A.2 Вывести на консоль те числа, длина которых меньше
            //   (больше) средней.
            double mean = TaskA.mean(arr);
            System.out.print("Числа меньше " + mean + " таковы: ");
            for (int i : arr) {
                if (i < mean) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            //A.3 Найти число, состоящее только из различных цифр.
            //Если таких чисел несколько, найти первое из них.
            for (int i : arr) {
                if (TaskA.uniqueDigits(i)) {
                    System.out.println("Найдено число из разных цифр: " + i);
                    break; //больше ничего не ищем
                }
            }

        System.out.println("----------------Часть Б--------------------");

        //Б.1 Определить принадлежит ли значение k интервалу [m, n]
        TaskB.ifInterval();

        //Б.2  Вывести числа от 1 до k ввиде матрицы N x N слева на право и сверху вниз
        // (k выберите квадратом целого числа).
        TaskB.printMatrix();

        //Б.3 Найти корни квадратного уравнения
        TaskB.quadraticEquation();

        //Б.4 Ввести число от 1 до 12 и вывести название соответствующего месяца
        TaskB.printMonth();
    }
}
