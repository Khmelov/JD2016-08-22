package by.it.dubatovka.jd01_05;

/**
 * Created by Sergey Dubatovka on 06.09.2016.
 */
public class RunnerMathVar4 {
    public static void main(String[] args) {

        double a = -3.45;
        double b = 349.1;

        System.out.println("Вариант 4.");
        System.out.println("1.1 Разбивка по частям.");
        System.out.println(Task1.task11(a, b));
        System.out.println();

        System.out.println("1.2  Полное выражение:");
        System.out.println(Task1.task12(a, b));
        System.out.println("----------------------------------------");

        double x = 3.24;
        double a1 = 5.8;
        System.out.println();
        System.out.println("2. Задание №2:");
        System.out.println(Task2.task2(x, a1));

        double x1 = 12.1;
        double deltaC = 0.5;

        System.out.println();
        System.out.println("2. Задание №3:");
        Task3.task3(x1, deltaC);

    }
}
