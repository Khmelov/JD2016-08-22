package by.it.dubatovka.JD01.jd01_05;

/**
 * Created by Dubatovka Sergey on 08.09.2016.
 */

import static java.lang.Math.*;

public class Task_6 {

    public static double[] get_Array() {
        //z=e^|2b+1|, (-2;2)
        int bStart = -2;
        int bEnd = 2;
        double deltaB = 0.2;

        //считаем размер массива и создаем его
        int razmerMassiva = (int) ((bEnd - bStart) / deltaB + 1);
        double z[] = new double[razmerMassiva];

        int i = 0;
        for (double b = -2; b <= 2; b += 0.2) {
            z[i] = pow(E, abs(2 * b + 1));
            i++;
        }
        return z;
    }

    public static void print_Array(double[] z, String s) {
        //печать заголовка
        System.out.println(s);
        //печать массива
        for (int i = 0; i < z.length; i++) {
            System.out.printf("%-1s%2d%-4s%-6.3f", "[", i, "] = ", z[i]);
            System.out.println();
        }
    }


    public static double[] get_EveryThirdElement(double z[]) {
        int j = 0;
        int razmerMassiva = 0;
            //считаем размер массива
        for (int k = 1; k < z.length; k += 2) {
            if (z[k] < 3) razmerMassiva++;
        }
        //создаем массив
        double b[] = new double[razmerMassiva];

        //записываем данные, нечетные элементы меньше 3
        for (int k = 1; k < z.length; k += 2) {
            if (z[k] < 3) {
                b[j] = z[k];
                j++;
            }
        }
        return b;
    }

    public static double proizvedenieElemArray(double z[]){
        if (z.length==1) return z[0];

        for (int i = 1; i < z.length; i++)
           z[0]=z[0]*z[i];

        return z[0];
    }

}

