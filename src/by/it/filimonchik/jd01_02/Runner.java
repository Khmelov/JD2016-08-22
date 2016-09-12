package by.it.filimonchik.jd01_02;

import java.util.Scanner;

/**
 * Created by Raman.Filimonchyk on 04.09.2016.
 */
public class Runner {

    public static void main(String[] args) {

        String line = Util.getLineFromConsole();
        System.out.println("Массив строк = " + line);
        int mas[] = Util.getIntFromLine(line);
        String arrStr[] = line.split(" ");

        System.out.println("Задача А1");
        String maxStr = TaskA.maxLength(arrStr);
        System.out.println("Самое длинное число = " + maxStr);
        System.out.println("Длина этого числа = " + maxStr.length());

        String minStr = TaskA.minLength(arrStr);
        System.out.println("Самое короткое число = " + minStr);
        System.out.println("Длина этого числа = " + minStr.length());

        System.out.println("Задача А2");
        double mean = TaskA.mean(mas);
        System.out.println("Среднее арифметическое: " + mean);
        for (int i : mas) {
            if (i < mean) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nЗадача А3");
        for (String i : arrStr) {
            if (TaskA.uniqueDigits(i)) {
                System.out.print("Число из разных чисел: " + i);
                break;
            }
        }
    }
}