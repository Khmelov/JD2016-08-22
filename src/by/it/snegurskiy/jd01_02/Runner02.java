package by.it.snegurskiy.jd01_02;


import java.lang.*;

/**
 * Created by user on 24.08.2016.
 */
public class Runner02 {
    public static void main(String[] args) {


//
//        String line = "11 22 -22 333 -333 12";
//        //String line= Util.getLineConsole();
//        System.out.println("Набор чисел " + line);
//        System.out.println();
//
//
//        //for (int i : arr) {
//        //    System.out.println(i + " ");
//        //Задание А1
//        String strMas[] = line.split(" ");
//        System.out.println("Задание А1:");
//        System.out.println("MAX " + A.maxLength(strMas));
//        System.out.println("MIN " + A.minLength(strMas));
//        System.out.println();
//
//        // Задание А2
//        int arr[] = Util.getIntArray(line);
//        int mean = A.mean(arr);
//        System.out.println("Задание А2:");
//        System.out.print("Числа меньше " + mean + " следующие:");
//        for (int i : arr) {
//            if (i < mean) {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();
//        System.out.println();
//
//
//        //Задание А3
//        System.out.println("Задание А3");
//                for (int i = 0; i <arr.length ; i++) {
//            if (A.uniqueDigits(arr[i])){System.out.println("найдено число из разных цифр: " + arr[i]);
//        } else if (i==arr.length-1){System.out.println("не найдено число из разных цифр");}
//        }


//        //Задание В1
//        System.out.println("Введите начало и конец интервала");
//        int start=Util.getIntConsole();
//        int end=Util.getIntConsole();
//        System.out.println("Введите искомое число");
//        int x=Util.getIntConsole();
//        if (x>start&x<end) System.out.println("число принадлежит интервалу");
//        else System.out.println("число не принадлежит интервалу");




        // Задание В2
        System.out.println("Введите число до какого будет вывод чисел");
        int endNumber=Util.getIntConsole();
        System.out.println("Введите размер матрицы");
        int sizeArray=Util.getIntConsole();
        for (int i = 1; i <=endNumber ; i++) {
            System.out.print("  "+i+"  ");
            if (i%sizeArray==0) System.out.println();

        }
//


}}



