package by.it.filimonchik.jd01_02;

import java.util.Scanner;

/**
 * Created by Raman.Filimonchyk on 04.09.2016.
 */
public class Util {
    public static String getLineFromConsole() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        scan.close();
        return line;
    }

    public static int[] getIntFromLine(String line) {
        String[] strMas = line.split(" ");
        int result[] = new int[strMas.length];
        for (int j = 0; j < strMas.length; j++) {
            result[j] = Integer.parseInt(strMas[j]);
        }
        return result;
    }
}