package by.it.opiga.JD01_02;


import java.util.Scanner;

public class TaskB {
    static boolean inInterval(int num, int n, int m)
    {
        if (num>n && num<m)
            return true;
        else return false;
    }


    static int printNum(int num, int col)
    {
        for (int i = 1; i <= col; i++) {
            System.out.print(" "+num);
            num++;

        }return num;
    }

       static double[] calc(double a1, double a2,double a3)
    {   double dmas[]=new double[2];
        double var=Math.abs(a2*a2-4*a1*a3);
          dmas[0]=(-a2+ var)/(2*a1);
          dmas[1]=(-a2- var)/(2*a1);
        return dmas;
    }

    static String printMonth(String c)
    {
        switch (c) {
            case "1": {return "январь";}
            case "2": {return "февраль";}
            case "3": {return "март";}
            case "4": {return "апрель";}
            case "5": {return "май";}
            case "6": {return "июнь";}
            case "7": {return "июль";}
            case "8": {return "август";}
            case "9": {return "сен";}
            case "10": {return "окт";}
            case "11": {return "ноя";}
            case "12": {return "дек";}
        }return "неверно введено число";
    }
    static void test(){
        int f = 0;
        while (f < 10) {
            f++;
            do {
                f++;
            }while(f<8);
        }

    }
}
