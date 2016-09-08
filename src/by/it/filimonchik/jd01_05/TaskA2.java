package by.it.filimonchik.jd01_05;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by Raman.Filimonchyk on 06.09.2016.
 */
public class TaskA2 {
    public static double one (double x, double f){
return ((sin(pow((PI/8-f), 2))+ pow(3 + pow(x, 2), 1/4))/2);
    }
}
