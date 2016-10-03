package by.it.prymshyts.jd01.jd01_06;

import by.it.prymshyts.jd01.jd01_02.Util;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Изначальный текст:\n-----");
        System.out.println(Data.poem);
        System.out.println("-----\n");

        // Задание А
        System.out.println("Задание А:");

        // 1
        System.out.println("Задание 1:\n-----");
        System.out.println(TaskA.t1(Data.poem));
        System.out.println("-----\n");

        // 2
        System.out.println("Задание 2:\n-----");
        TaskA.t2(Data.poem);
        System.out.println("-----\n");

        // 3
        System.out.println("Задание 3:\n-----");
        TaskA.t3(Data.poem);
        System.out.println("-----\n");


        // Задание В
        System.out.println("Задание В:");

        // 1
        System.out.println("Задание 1:\n-----");
        System.out.println(TaskB.t1(Data.poem));
        System.out.println("-----\n");

        // 2
        System.out.println("Задание 2:\n-----");
        System.out.println(TaskB.t2(Data.poem));
        System.out.println("-----\n");

        // 3
        System.out.println("Задание 3:\n-----");
        System.out.print("Введите букву: ");
        char letter = Util.getConsoleLine().charAt(0);
        System.out.println(TaskB.t3(Data.poem, letter));
        System.out.println("-----\n");


        // Задание С
        System.out.println("Задание С:");

        // 1
        System.out.println("Задание 1:\n-----");
        System.out.print(TaskC.t1(Data.poem));
        System.out.println("-----\n");

        // 2
        System.out.println("Задание 2:\n-----");
        TaskC.t2(Data.poem);
        System.out.println("-----\n");

        // 3
        System.out.println("Задание 3:\n-----");
        System.out.print(TaskC.t3(Data.poem));
        System.out.println("-----");
    }
}
