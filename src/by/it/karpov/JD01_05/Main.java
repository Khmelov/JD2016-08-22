package by.it.karpov.JD01_05;

public class Main {

    public static void main(String[] args) {
        //Задача 1
        double x = 234.1;
        System.out.println(Task1.count_1(x));
        System.out.println(Task1.count_2(x));
        //Задача 2
        System.out.println(String.format("%(.2f", Task2.count(0.3, -21.17)));
        //Задача 3
        Task3.printTable();
        //Задача 4
        System.out.println(Task4.calculation(0.5));
        //Задача 5
        Task5.calculate();
    }

}
