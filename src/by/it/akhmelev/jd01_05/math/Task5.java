package by.it.akhmelev.jd01_05.math;

import static java.lang.Math.*;

public class Task5 {

    public static void calculate(){

        double beta;
        for (double x = -5.0; x < 2.0; x += 0.5){

            if (x / 2 > -2 && x / 2 <= -1){
                beta = sin(pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2){
                beta = cos(pow(x, 2));
            } else if (x / 2 == 0.2){
                beta = 1 / tan(pow(x, 2));
            } else{
                continue;
            }
            double alpha = log10(abs(beta + 2.74));
            System.out.println(String.format("%1s%25s", x, alpha));
        }
    }
}
