package by.it.prymshyts.jd01_05;

import static java.lang.Math.pow;

public class Task4 {

    protected static double calculate() {

        double sum = 0;

        for (double x = 1; x <= 8; x++) {
            for (int i = 6; i <= 11; i++) {
                sum += pow(x + 2, 1.3 * i);
            }
        }

        return sum;
    }
}
