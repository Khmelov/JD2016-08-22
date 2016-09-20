package by.it.shkantau.jd01_05;
import static java.lang.Math.*;

/**
 * Created by Aliaksei on 20.09.2016.
 */
public class Task2 {

    public static double task2(double a, double b){
        return  pow(a+1.5 , 1/3) + pow(a-b, 8) - b/asin(abs(a*a));
    }

}
