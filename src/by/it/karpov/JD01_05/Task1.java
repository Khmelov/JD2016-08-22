package by.it.karpov.JD01_05;

import static java.lang.Math.*;

public class Task1
{
    //полное выражение
    public static double count_1(double x)
    {
        double y1;
        y1=(pow(sin(PI/2+1),2)+x*pow((3+pow(x,2)),0.25)-pow((tan(pow(x,3)-1)),3))/((atan(x/2)+2*atan(1))-log(17.56));
        return round(y1);
    }
    //раздельная запись
    public static double count_2(double x)
    {
        double a,b,c,d,y2;
        a=pow(sin(PI/2),2);
        b=x*pow((3+pow(x,2)),0.25);
        c=pow(tan(pow(x,3)-1),3);
        d=((atan(x/2)+2*atan(1))-log(17.56));
        y2=(a+b-c)/d;
        return round(y2);

    }
}