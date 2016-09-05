package by.it.opiga.JD01_05;

/**
 * Created by user on 05.09.2016.
 */
public class Task4 {

public static double calcSum()
{

    double a=2.408;
    double db=0.02;
    double z=1.38-a;

    for (double b=0.2; b <=0.4 ; b+=db) {
            for (double c = 1; c <=12 ; c++) {
            z=z+Math.pow(c+b,2);
                System.out.println("b= "+b+"    c= "+c+"   z= "+z);
        }
    }return z;
 }


}
