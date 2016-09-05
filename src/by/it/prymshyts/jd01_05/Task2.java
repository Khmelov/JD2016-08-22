package by.it.prymshyts.jd01_05;

import static java.lang.Math.tan;
import static java.lang.Math.pow;
import static java.lang.Math.log10;

public class Task2 {

    protected static double calculate() {

        double a = 1.21, b = 0.371;
        return tan(pow(a + b, 2)) - pow(a + 1.5, 1 / 3) + a * pow(b, 5) - (b / log10(pow(a, 2)));
    }
}
