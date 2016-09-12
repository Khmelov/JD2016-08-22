package by.it.karpov.JD01_05;

import static java.lang.Math.*;
public class Task4 {

    public static double calculation(double x)
    {
        double step=0.2;
        final double A1=0;
        final double A2=2;
        double y;
        for(y=1;y<=6;y++) {
            for (double m = A1; m <= A2; m += step) {
                y += pow(7, m) - cos(x);
            }
        }
        return round(y);
    }

}