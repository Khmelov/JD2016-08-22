package by.it.opiga.JD01_05;
import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by Asus on 04.09.2016.
 */
public class Task2 {
public static double findY(double x,double f)
{
    double y=(pow(sin(PI/8-f),2)+pow(3+x*x,1/4))/2;
    return y;
}


}
