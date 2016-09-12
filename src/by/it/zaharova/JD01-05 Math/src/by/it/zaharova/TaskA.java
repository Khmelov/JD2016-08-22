package by.it.zaharova;


import java.util.Scanner;

public class TaskA {
    public static double Z() {

        double x = 10.093;
        double a = 0.94;
        double z;
        double z1 = (Math.acos(Math.toRadians(x)));
        double z2 = (a * Math.sqrt(x));
        double z3 = (Math.pow(Math.sin(Math.toRadians((Math.PI) / 2 + a)), 3) / Math.log10(2 * x));
        return z1 - z2 + z3;
    }

//убрала из arccos x^2 степень 2.

    public static double PolnZ() {
        double x = 10.093;
        double a = 0.94;
        double z;
        double Z= (Math.acos(Math.toRadians(x)))-(a * Math.sqrt(x))+(Math.pow(Math.sin(Math.toRadians((Math.PI) / 2 + a)), 3) / Math.log10(2 * x));
        return Z;
    }

    ///////////////////////////////////
    public static double ZapolnZ(){
        double a=0.00094;
        double x=10.093;
        double z =(a * Math.sqrt(x)) - a*Math.sqrt(x/(Math.pow(a,3))) +(Math.pow(Math.sin(Math.toRadians((Math.PI) / 2 )), 3) / Math.log10(2 * x)) ;
        return z;
    }

    public static void In(){
        Scanner scanner = new Scanner(System.in);
        double a;
        System.out.println("Введите а: ");
        a= scanner.nextDouble();
        double x;
        System.out.println("Введите х: ");
        x= scanner.nextDouble();
        double z =(a * Math.sqrt(x)) - a*Math.sqrt(x/(Math.pow(a,3))) +(Math.pow(Math.sin(Math.toRadians((Math.PI) / 2 )), 3) / Math.log10(2 * x)) ;
        System.out.println("Значение выражения" + z);
    }

    ////////////////////////////////////////

    public static void Tabl(){
        double x =3.567;
        double y;

        for (double a = -5; a <=12 ; a+=2.5) {
            y = 1/Math.tan(Math.pow(x,3)) + 2.24*a*x;
            System.out.println("Значение выражения" + y);

        }
    }
}