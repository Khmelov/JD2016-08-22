package by.it.grechishnikov.jd01_05;

import static java.lang.Math.*;

public class Task1 {
    public static double task1(double x) {
        //По частям
        double a = PI / 2 + 1;
        double first = pow(sin(a), 2);

        a = 3 + pow(x, 2);
        double second = x * pow((a), 1.0 / 4);

        a = pow(x, 3) - 1;
        double third = pow(tan(a), 3);

        double forth = atan(x / 2);

        double fifth = log(17.56);

        return (first + second - third)/(forth - fifth);
    }

    public static double task2(double x) {
        //Сразу
        return ((pow(sin(PI / 2 + 1), 2)) + (x * pow((3 + pow(x, 2)), 1.0 / 4)) - pow(tan(pow(x, 3) - 1), 3)) / ((atan(x / 2)) - (log(17.56)));
    }
}
