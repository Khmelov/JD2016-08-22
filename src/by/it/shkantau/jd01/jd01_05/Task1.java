package by.it.shkantau.jd01.jd01_05;

import static java.lang.Math.*;

public class Task1 {

    public static double task1  (double a, double x){
        double b = pow(cos(pow(x,2) + PI/6),5);
        double c = - sqrt(x*pow(a,3));
        double d = - log(abs((a - 1.12*x)/4));
        return  b + c + d;

    }

    public static double task2(double a, double x){
        return pow(cos(x*x + PI/6),5) - sqrt(x*pow(a,3)) - log(abs((a - 1.12*x)/4));
    }

}
