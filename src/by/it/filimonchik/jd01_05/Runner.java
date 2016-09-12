package by.it.filimonchik.jd01_05;

/**
 * Created by Raman.Filimonchyk on 06.09.2016.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Variant 17");
//      Задание 1. Часть 1.
        System.out.println("Task 1. Part 1");
        System.out.println(TaskA1.first(1.21, 0.371));
//      Задание 1. Часть 2.
        System.out.println("Task 1. Part 2");
        System.out.println(TaskA1.second(1.21, 0.371));
//      Задание 2.
        System.out.println("Task 2.");
        System.out.println(TaskA2.one(2.57E3, 0.873));
//      Задание 3.
        System.out.println("Task 3.");
        TaskA3.Table();
    }
}
