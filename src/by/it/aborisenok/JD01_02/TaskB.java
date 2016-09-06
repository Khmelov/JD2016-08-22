package by.it.aborisenok.JD01_02;

import java.io.IOException;

/**
 * Created by user on 05.09.2016.
 */
public class TaskB {
    //Б.1 принадлежит ли число интервалу
    public static void ifInterval() throws IOException {
        System.out.println("Задание Б.1");
        System.out.println("Введите начало интервала m, конец интервала n, и значение value");
        int m = Util.lineToInt();
        int n = Util.lineToInt();
        int value = Util.lineToInt();
        if ((value >= m) && (value <= n) ) {
            System.out.printf("Значение %d принадлежит интервалу [%d, %d]", value, m, n);
        }
        else {
            System.out.printf("Значение %d не принадлежит интервалу [%d, %d]", value, m, n);
        }
    }

    //Б.2 Вывод чисел в виде матрицы
    public static void printMatrix() throws IOException {
        System.out.println("Задание Б.2");
        System.out.println("Введите размер матрицы");
        int number = Util.lineToInt();
        int count = 1;
        for (int i = 0; i < number; i++){
            for (int j = 0; j < number; j++){
                System.out.print("\t" + count);
                count++;
            }
            System.out.println();
        }

    }

    //Б.3 Найти корни квадратного уравнения
    public static void quadraticEquation() throws IOException {
        System.out.println("Задание Б.3");
        System.out.println("Введите коэффициенты [a], [b], [c]");
        int a = Util.lineToInt();
        int b = Util.lineToInt();
        int c = Util.lineToInt();

        int dis = b*b - 4*a*c;
        if (dis < 0) {
            System.out.println("Уравнение не имеет корней");
        } else
            if (dis == 0) {
                double x = (-b/(2*a));
                System.out.println("Уравнение имеет один корень x = " + x);
            } else
                if (dis > 0) {
                    double x1 = (-b + Math.sqrt(dis))/(2*a);
                    double x2 = (-b - Math.sqrt(dis))/(2*a);
                    System.out.println("Уравнение имеет два корня х1 = " + x1 + " x2 = " + x2);
                }
    }

    public static void printMonth() throws IOException {
        System.out.println("Задание Б.4");
        System.out.println("Введите номер месяца");
        int monthNumb = Util.lineToInt();
        while ((monthNumb < 1) ||(monthNumb > 12) ) {
            System.out.println("Неверное значение, попробуйте ещё раз");
            monthNumb = Util.lineToInt();
        }
        String[] mounthArr = {"Январь", "Февраль", "Март", "Апрель",
                              "Май", "Июнь", "Июль", "Авгус", "Сентябрь",
                              "Октябрь", "Ноябрь", "Декабрь"};
        System.out.println("Название " + monthNumb + " месяца - " + mounthArr[monthNumb - 1]);
    }
}
