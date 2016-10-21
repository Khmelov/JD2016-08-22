package by.it.snegurskiy.jd01.jd01_13;

import java.util.Scanner;

/**
 * Created by snegurskiy.nn on 20.09.2016.
 */
public class A13 {

    public static void A1() throws Exception {
        double sum=0;
        for (int i = 0; i <5 ; i++) {
            try {
                System.out.println("Введите положительное число");
                Scanner in = new Scanner(System.in);
                String s = in.next();
                if (s.equals("END")) break;
                try {
                    int sInt = new Integer(s);
                } catch (NumberFormatException e) {
                    i--;
                    System.out.println("введено не число");
                }
                int sInt = new Integer(s);
                if (sInt < 0) {
                    i--;
                    throw new Exception13("Введено отрицательное число");

                }
                sum = sum + Math.sqrt(sInt);

                System.out.println(sInt + " " + sum);


            } catch (Exception Exception13) {
                System.out.println(Exception13);
            }


        }
        System.out.println("END");
    }
}
