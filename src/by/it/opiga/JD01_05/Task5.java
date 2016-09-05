package by.it.opiga.JD01_05;

/**
 * Created by user on 05.09.2016.
 */
public class Task5 {
    public static double findY() {
        double a = 0.491 * Math.pow(10, 4);
        double y = a;
        double p = -2;
        double dp = 3;
        double x;
        p = p + dp;
        while (p > -2 && p < 11) {
            if (1.5 * p < 1.5) {
                x = Math.pow(Math.acos(p), 2);
                y = y + 1.39 * x;
                System.out.printf("p = %-3.3f x = %-6.3f y = %-6.3f \n", p, x, y);
            }
            if (1.5 * p >= 1.5 && 1.5 * p < 3) {
                x = Math.pow(Math.E, p) + 3.5;
                y = y + 1.39 * x;
                System.out.printf("p = %-3.3f x = %-6.3f y = %-6.3f \n", p, x, y);
            }
            if (1.5 * p > 3) {
                x = p + 4.76;
                y = y + 1.39 * x;
                System.out.printf("p = %-3.3f x = %-6.3f y = %-6.3f \n", p, x, y);
            }

            p = p + dp;
        }
        return y;
    }


}
