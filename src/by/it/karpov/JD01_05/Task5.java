package by.it.karpov.JD01_05;

import static java.lang.Math.*;
public class Task5 {

    public static void calculate() {
        double b=0;
        double a=0;
        double x;
        double step = 0.5;
        System.out.println("   x     y   ");
        for (x = -6; x < 2; x += step) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
            } else if (x / 2 == 0.2) {
                b = (atan(pow(x, 2)) + 2 * atan(1));
            }
            a = log10(abs(b + 2.74));
            System.out.printf("%5.1f   %5.2f\n", x, a);
        }
    }
}
