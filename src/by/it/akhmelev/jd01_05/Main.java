package by.it.akhmelev.jd01_05;

import by.it.akhmelev.jd01_05.math.*;

//пример решения задачек по модулю Math (уровни A и B)
//это реальный образец работы студентов прошлых выпусков JD01
//вы можете реализовать свой вариант примерно таким же образом

public class Main {
    public static void main(String[] args) {
        // Задача 1
        double x = 1.5;
        System.out.println(Task1.optionA(x));
        System.out.println(Task1.optionB(x));

        // Задача 2
        System.out.println(Task2.calculate(0.3, -21.17));

        // Задача 3
        Task3.printTable();

        // Задача 4
        System.out.println(Task4.calculate(2.408));

        // Задача 5
        Task5.calculate();

        // Задача 6
        double a[] = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "testname", true);
        double b[] = task6.getEveryThirdElement(a);
        task6.printArray(b, "array", true);
    }
}
