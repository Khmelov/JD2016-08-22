package by.it.grechishnikov.jd01_05;

import static java.lang.Math.*;

public class Task2 {
    public static double calculate(double a, double b) {
        return pow(1 / tan(PI / 4 - 1), 4) + (pow((a + 1.5), 3)) - (b / (asin(abs(pow(a, 2)))));
    }
}
