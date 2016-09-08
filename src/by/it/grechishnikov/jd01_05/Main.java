package by.it.grechishnikov.jd01_05;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант 6");
//        Задание 1
        double x = 234.1;
        System.out.println(Task1.task1(x));
        System.out.println(Task1.task2(x));

        //Задание 2
        double a = 0.3, b = -21.17;
        System.out.println(Task2.calculate(a, b));

        //Задание 3
        Task3.print();

        //Задание 4
        System.out.println(Task4.calculate(2.5));

        //Задание 5
        Task5.calculate();

        //дополнительно на оценку
        list();
    }

    private static void list() {
        System.out.println("\n***Методы класса Math***");
        Method[] methods = Math.class.getMethods();
        for(Method m : methods) {
            System.out.println(m.getName());
        }
    }
}
