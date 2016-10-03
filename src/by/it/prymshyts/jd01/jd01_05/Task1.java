package by.it.prymshyts.jd01.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    protected static double optionA() {

        double A = 756.13, X = 0.3;
        double a = cos(pow((pow(X, 2) + PI / 6), 5));
        double sqrtArg = X * pow(A, 3);

        if (sqrtArg < 0) {
            System.out.println("Аргумент для корня меньше нуля, был взят его моудль.");
            sqrtArg = abs(sqrtArg);
        }

        double b = sqrt(sqrtArg);
        double logArg = abs((A - 1.12 * X) / 4);

        if (logArg < 0) {
            System.out.println("Аргумент для логарифма меньше нуля, был взят его моудль.");
            logArg = abs(logArg);
        }

        double c = log10(logArg);

        return (a - b - c);
    }

    protected static double optionB() {

        double A = 756.13, X = 0.3;
        return cos(pow((pow(X, 2) + PI / 6), 5)) - sqrt(X * pow(A, 3)) - log10(abs((A - 1.12 * X) / 4));
    }
}
