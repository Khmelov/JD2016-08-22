package by.it.opiga.JD01_05;


//import java.lang.Math.*;
/**
 * Created by Asus on 04.09.2016.
 */
public class Task1 {
    public static double part(double a, double b)
    {
        double y1=Math.pow(Math.atan(Math.PI/4-1),4);
        double y2=Math.pow(a+1.5,1/3);
        double y3=Math.pow(a-b,8);
        double a2=Math.toRadians(a);
        double y4=b/(Math.pow(Math.asin(Math.abs(a2)),2));
        double y=y1+y2+y3-y4;
        return y;
    }
    public static double whole(double a, double b)
    {   double a2=Math.toRadians(a);
        double y=Math.pow(Math.atan(Math.PI/4-1),4)+Math.pow(a+1.5,1/3)+Math.pow(a-b,8)-b/(Math.pow(Math.asin(Math.abs(a2)),2));
        return y;
    }




}
