package by.it.zaharova.JD01_12;

import java.util.Scanner;

public class Util {

    private static Scanner scanner = new Scanner(System.in);

       public static int getRandomNum(int min, int max) {

        return min + (int)(Math.random() * ((max - min) + 1));
    }
}
