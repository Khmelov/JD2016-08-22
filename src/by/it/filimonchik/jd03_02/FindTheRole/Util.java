package by.it.filimonchik.jd03_02.FindTheRole;

import java.util.Scanner;

class Util {
    public static String getLineFromConsole() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
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
