package by.it.prymshyts.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    protected static double optionA() {

        double A = 756.13, X = 0.3;
        double a = cos(pow((pow(X, 2) + PI / 6), 5));
        double b = sqrt(X * pow(A, 3));
        double c = log10(abs((A - 1.12 * X) / 4));

        return (a - b - c);
    }

    protected static double optionB() {

        double A = 756.13, X = 0.3;
        return cos(pow((pow(X, 2) + PI / 6), 5)) - sqrt(X * pow(A, 3)) - log10(abs((A - 1.12 * X) / 4));
    }
}
