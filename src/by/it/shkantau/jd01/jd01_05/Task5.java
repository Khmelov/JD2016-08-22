package by.it.shkantau.jd01.jd01_05;

import static java.lang.Math.*;

public class Task5 {

    public static void calculate(){

        double z;
        double r = 4910;
        double y;
        System.out.println("Task5");
        for (double p = -2.0; p < 15.0; p += 1.5){
            if ((p -1) < 0){
                z = p - 3.18*cos(p+1);
            } else if ((0 <= (p-1)) && ((p-1) < 3)){
                z = pow(p, 3) - tan(p);
            } else if ((p-1)>=3){
                z = pow(p + sin(PI/6), 5);
            } else
                continue;
            y = sqrt(abs(z - 2.56 * r));
            System.out.println(String.format("p = %5.2f; y = %.2f", p, y));
        }
    }

}
