package by.it.prymshyts.jd01.jd01_05;

import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Task5 {

    protected static void calculate(){

        double r = 0.491 * pow(10, 2);  // По заданию степень четвёртая, заменил на вторую,
        double z, y;                     // т.к. иначе в ответе "Infinity".

        for (int p = -2; p < 15; p += 1.5) {

            if ((p - 1) < 0) {
                z = 3.8 * sin(p);
            } else if ((p - 1) >= 0 && (p - 1) < 3) {
                z = pow((p - 1), 3) - (p - 1);
            } else if ((p - 1) >= 3) {
                z = pow((2 / (p + 1) + sin(PI / 6)), 5);
            } else {
                continue;
            }

            y = pow(4.67, abs(z - 1.4 * r));

            System.out.printf("%2s%25s\n", p, y);
        }
    }
}
