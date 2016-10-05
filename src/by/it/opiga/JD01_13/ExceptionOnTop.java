package by.it.opiga.JD01_13;

import java.util.Scanner;

/**
 * Created by Asus on 04.10.2016.
 */
public class ExceptionOnTop {
    public static void main(String[] arg) {
        //задание А
        Scanner scan = new Scanner(System.in);
        String tmp = scan.nextLine();
        while (!tmp.equals("END")) {
            CalcSum.calcSum(tmp);
            tmp = scan.nextLine();
        }
    }

}

