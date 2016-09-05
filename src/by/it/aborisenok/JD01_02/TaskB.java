package by.it.aborisenok.JD01_02;

import java.io.IOException;

/**
 * Created by user on 05.09.2016.
 */
public class TaskB {
    //принадлежит ли число интервалу
    public static void ifInterval() throws IOException {
        System.out.println("Введите через пробел начало интервала m, конец интервала n, и значение value");
        String line = Util.getOneLine();
        int[] param = Util.lineToIntArray(line);
        int m = param[0];
        int n = param[1];
        int value = param[2];
        if ((value >= m) && (value <= n) ) {
            System.out.printf("Значение %d принадлежит интервалу [%d, %d]", value, m, n);
        }
        else {
            System.out.printf("Значение %d не принадлежит интервалу [%d, %d]", value, m, n);
        }
    }

    // Вывод чисел в виде матрицы

    // Найти корни квадратного уравнения
    public static void quadraticEquation() throws IOException {
        System.out.println("Введите через пробел коэффициенты [a], [b], [c]");
        String line = Util.getOneLine();
        int[] koef = Util.lineToIntArray(line);
        int a = koef[0];
        int b = koef[1];
        int c = koef[2];

        int dis = b*b - 4*a*c;
        System.out.println(dis);
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
}
