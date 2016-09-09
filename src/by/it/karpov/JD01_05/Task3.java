package by.it.karpov.JD01_05;

import static  java.lang.Math.*;
public class Task3 {

    public static void printTable()
    {
        double x=12.1;
        double step=2.5;
        final double A1=3.5;
        final double A2=25.5;

        System.out.println("   \u0394a     y   ");
        for(double da=A1;da<=A2;da+=step)
        {
            double y=sin((x/3))+1.2*da;// arcsin(y)=NaN
            System.out.printf("%5.1f   %5.2f\n",da,y);
        }
    }
}
