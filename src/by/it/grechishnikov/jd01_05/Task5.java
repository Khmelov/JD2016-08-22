package by.it.grechishnikov.jd01_05;

import static java.lang.Math.*;

public class Task5 {
    static void calculate() {
        double b;
        for(double x = -6.0; x < 2.0; x+= 0.5) {
            if(-2.0 < x / 2 && x / 2 <= -1.0) {
                b = sin(pow(x, 2));
            } else if(-1.0 < x / 2 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
            } else if(x / 2 == 0.2) {
                b = tan( 1 / pow(x, 2));
            } else continue;
            double a = log(b + 2.74);
            System.out.printf("x = %5.2f; alpha = %.2f\n", x, a);
        }
    }
}
