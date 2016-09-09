package by.it.opiga.JD01_05;

import static java.lang.Math.abs;
import static java.lang.Math.toDegrees;
import static java.lang.Math.toRadians;

/**
 * Created by user on 05.09.2016.
 */
public class Task6 {

    public static void fullMas() {
        double f1 = -8;
        double f2 = -2;
        double step = 0.2;
        double a[] = new double[30];
        double a2[] = new double[30];
        int col = 0;
        double mult = 1;

        while (f1 < f2) {
            a[col] = Math.cos(abs(f1 / 2));
            System.out.printf("a[%d] = %-4.2f \n", col, a[col]);
            col++;
            f1 = f1 + step;
        }
        col = 0;
        int col2 = 0;
        while (col < a.length) {
            if (a[col] < 0 && (col % 2) == 1) {
                a2[col2] = a[col];
                mult = mult * a[col];
                col2++;
            }col++;
        }
        System.out.println("ппроизведение отриц элементов с нечтными индексами: "+mult);
    }
}





