package by.it.snegurskiy.jd01.jd01_05;

import static java.lang.Math.pow;
import static java.lang.Math.tan;

/**
 * Created by user on 05.09.2016.
 */
public class Task3 {
    public static void printTable(){

        double x = 3.567;

        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━┓");
        System.out.println("┃ param      ┃        value         ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━┫");
        for (double a = 3.5; a <= 25.5; a += 3.75){
            double y = (1.0 / tan(pow(x, 3))) + 2.24 * a * x;
            System.out.println(String.format("%-3s%-10.5s%-2s%-21.10s%-5s", "┃", a, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━┛");
    }
}
