package by.it.aborisenok.JD01_02;

import java.io.IOException;

/**
 * Created by user on 05.09.2016.
 */
public class TaskB {
    //принадлежит ли число интервалу
    public static void ifInterval() throws IOException {
        System.out.println("Введите начало интервала");
        String sBegin = Util.getOneLine();
        int begin = Integer.parseInt(sBegin);
        System.out.println("Введите конец интервала");
        int end = Util.lineToNumber(Util.getOneLine());
        System.out.println("Введите искомое значение");
        int value = Util.lineToNumber(Util.getOneLine());

        if ((value >= begin) && (value <= end) ) {
            System.out.printf("Значение %d принадлежит интервалу [%d, %d]", value, begin, end);
        }
        else {
            System.out.printf("Значение %d принадлежит интервалу [%d, %d]", value, begin, end);
        }
    }

    // Вывод чисел в виде матрицы

    // Найти корни квадратного уравнения
    public static void quadraticEquation() throws IOException {
        System.out.println("Введите коэффициент a");
        int a = Util.lineToNumber(Util.getOneLine());
        System.out.println("Введите коэффициент b");
        int b = Util.lineToNumber(Util.getOneLine());
        System.out.println("Введите коэффициент c");
        int c = Util.lineToNumber(Util.getOneLine());

        int dis = b^2 - 4*a*c;
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
                    System.out.println("Уравнение имеет два корня х1 = " + x1 +  "x2 = " + x2);
                }
    }
}
