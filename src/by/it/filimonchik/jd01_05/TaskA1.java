package by.it.filimonchik.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Raman.Filimonchyk on 06.09.2016.
 */
public class TaskA1 {
    public static double first (double a, double b){
//        по частям
        double t = pow((a + b), 2);
        double FirstPart = tan(t);
        double PartTwo = cbrt(a + 1.5);
        double l = pow(b, 5);
        double ThirdPart = (a * l);
        double e = log10(a * a);
        double PartFour = (b / e);
        return (FirstPart - PartTwo + ThirdPart - PartFour);
    }
    public static double second (double a, double b){
//        целиком
        return tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log10(a * a);
}
}