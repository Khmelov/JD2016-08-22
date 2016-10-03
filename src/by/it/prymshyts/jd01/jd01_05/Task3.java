package by.it.prymshyts.jd01.jd01_05;

import static java.lang.Math.exp;

public class Task3 {

    public static void printTable(){

        double x = 12.1;

        System.out.println("┏━━━━┳━━━━━━━━━━━┓");
        System.out.println("┃ param ┃      value        ┃");
        System.out.println("┣━━━━╋━━━━━━━━━━━┫");


        for (double a = -5; a <= 12; a += 3.75){
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("%-2s%6s%-2s%-18.15s%s\n", "┃", a, "┃", f, "┃");
        }

        System.out.println("┗━━━━┻━━━━━━━━━━━┛");
    }
}
