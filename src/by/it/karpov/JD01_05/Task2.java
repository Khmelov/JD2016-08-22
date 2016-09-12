package by.it.karpov.JD01_05;

import static java.lang.Math.*;

public class Task2 {

    public static double count(double a, double b)
    {
        double y;
        y=pow((tan(PI/4-1)),4)+pow((a+1.5),1/3)-b/(asin(pow((abs(a)),2)));
        return y;
    }
}

