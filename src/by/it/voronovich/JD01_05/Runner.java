package by.it.voronovich.JD01_05;

import java.io.IOException;

/**
 * Класс запускает методы и выдает результат. Вариант №2
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */

public class Runner {
    public static void main(String[] args) throws IOException{

        System.out.println("Задание 1:");
        double a = 5.8;
        double x = 3.24;
        String z = MethodBodies.taskOne(a,x);
        System.out.println(z);
        System.out.println(" ");

        System.out.println("Задание 2:");
        //double x1 = InOut.getX();
        double x1 = 0.21e+2;
        double y = MethodBodies.taskTwo(x1);
        System.out.println(y);
        System.out.printf("%4.2e ",y);
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Задание 3:");
        double x2 = 3.567;
        MethodBodies.taskThree(x2);
        System.out.println(" ");

        System.out.println("Задание 4:");
        double a2 = 2.408;
        MethodBodies.taskFour(a2);
        System.out.println(" ");

        System.out.println("Задание 5:");
        double r = 0.473e+1;
        MethodBodies.taskFive(r);
        System.out.println(" ");

        System.out.println("Задание 6:");
        String name = "A";
        String name1 = "B";
        MethodBodies.taskSix(name, name1);
        System.out.println(" ");

        System.out.println("Задание 7:");
        MethodBodies.taskSeven();

    }
}
