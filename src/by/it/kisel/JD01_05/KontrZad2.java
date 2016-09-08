package by.it.kisel.JD01_05;

import java.util.Scanner;

public class KontrZad2 {
    public static double zad(){
        double a = 1.21, b = 0.371;
        double y;
        y = Math.tan(Math.toRadians(Math.pow(a+b,2)))-Math.pow(a+1.5,1/3)+a*Math.pow(b,5)-b/Math.log(Math.abs(a*a));
        return y;
    }

    public static void vvod(){
        Scanner scanner = new Scanner(System.in);
        double a, b;
        System.out.println("Введите a и b :");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        scanner.close();
        double y = Math.tan(Math.toRadians(Math.pow(a+b,2)))-Math.pow(a+1.5,1/3)+a*Math.pow(b,5)-b/Math.log(Math.abs(a*a));
        System.out.println("Значение выражения : " + y);
    }
}
