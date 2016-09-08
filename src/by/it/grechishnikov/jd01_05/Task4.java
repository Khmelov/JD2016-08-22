package by.it.grechishnikov.jd01_05;

/**
 * Created by Evgeniy on 05.09.16.
 */
public class Task4 {
    static double calculate(double x) {
        double sum = 0;
        for(double a = 3.5; a <= 25.5; a += 0.2) {
            for(int b = 1; b < 6; b++) {
                double d = b * Math.pow(7, a);
                sum += d;
            }
        }
        return sum - Math.cos(x);
    }
}
