package by.it.shkantau.jd01.jd01_05;

import static java.lang.Math.*;

public class Task4 {

    public static void task4(char operator, double tmin, double tmax , double step){
        for (double t = tmin; t <= tmax; t = t + 0.1) {
            double m = 1;
            for (int d = 23; d <= 39; d++){
                if (operator == '*') {
                    m *= log10(abs(d - t));
                }else if (operator == '+'){
                    m += log10(abs(d - t));
                }
            }
            System.out.printf("%-2s%-4.1f%-7s%-8.3f", "t=", t, " -->  m=", m);
            System.out.println();
        }
    }
}
