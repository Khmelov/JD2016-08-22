package by.it.dubatovka.jd01_05;

import static java.lang.Math.*;

public class Task2 {
    public static double task2(double x, double a) {

        double z = 1 / tan(x * x) + pow(cos(PI / 2 - a), 3) / abs(x - pow(a, 1 / 5));
        System.out.print("z= ");

        return z;

    }
}