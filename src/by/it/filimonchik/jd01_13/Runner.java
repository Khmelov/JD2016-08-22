package by.it.filimonchik.jd01_13;

import java.io.IOException;
import java.util.Scanner;

import static java.awt.Event.END;

/**
 * Created by Raman.Filimonchyk on 25/09/2016.
 */
public class Runner {
    public static void main(String[] args) {
        double Sum = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.nextLine();
            if(a.equals("END")){
                break;
            }
            try {
                double b = Double.valueOf(a);
                double result = +Math.sqrt(b);
                System.out.println(b + ": " + result);
            } catch (NumberFormatException e) {
                System.out.println("Введите число: ");
            }
        }
    }
}
