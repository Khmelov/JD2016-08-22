package by.it.dubatovka.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    public static double task11(double a, double b) {

        double x1, x2, x3, x4, y;
        //разбить выражение по частям
        x1 = pow(cos(PI / 4), 4);
        x2 = pow(a + 1.5, 1 / 5);
        x3 = a * pow(b, 8);
        x4 = b / log10(abs(a * a));

        y = x1 + x2 + x3 - x4;

        System.out.println("x1= " + x1);
        System.out.println("x2= " + x2);
        System.out.println("x3= " + x3);
        System.out.println("x4= " + x4);
        System.out.println();
        System.out.print("y= ");

        return y;
    }

    public static double task12(double a, double b) {

        double y = pow(cos(PI / 4), 4) + pow(a + 1.5, 1 / 5) + a * pow(b, 8) - b / log10(abs(a * a));

        System.out.print("y=");
        return y;
    }


}