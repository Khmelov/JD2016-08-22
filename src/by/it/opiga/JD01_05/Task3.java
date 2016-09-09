package by.it.opiga.JD01_05;

import static java.lang.Math.*;

/**
 * Created by Asus on 05.09.2016.
 */
public class Task3 {
    public static void printY()
    {
        double dt=0.1;
        double t=2;
        while (t<3.1){
            double s=log(abs(1.3+t))-pow(E,t);
            System.out.printf("t = %-3f  y = %f \n",t,s);
            t=t+dt;
        }
    }


}
