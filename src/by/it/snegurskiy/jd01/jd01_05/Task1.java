package by.it.snegurskiy.jd01.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.asin;
import static java.lang.Math.pow;

/**
 * Created by user on 05.09.2016.
 */
public class Task1 {
    public static double optionA(double x){
        //выражение отдельными фрагментами
        double a = pow(sin(PI / 6 - 1), 2);
        double b = pow(pow((3 + x), 2), 1 / 4);
        double c = pow(log10(pow(x, 3) - 1), 3);
        double d = asin(x / 2) - 1.756 * pow(10, -2);
        x = (a + b - c) / d;

        return x;
    }

    public static double optionB(double x){
        //выражение одной строкой
        x = (pow(sin(PI / 6 - 1), 2) + pow(pow((3 + x), 2),1/4) - pow(log10(pow(x, 3) - 1), 3)) / (asin(x / 2) - 1.756 * pow(10, -2));

        return x;
    }
}
