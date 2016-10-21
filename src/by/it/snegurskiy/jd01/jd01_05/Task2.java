package by.it.snegurskiy.jd01.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.asin;
import static java.lang.Math.pow;

/**
 * Created by user on 05.09.2016.
 */
public class Task2 {
    public static double calculate(double a, double b){
        double y;
        y = pow(1.0 / tan(PI / 4 - 1), 2) + pow(a + 1.5,1/3) - (b / asin(pow(a, 2)));
        return y;
    }
}
