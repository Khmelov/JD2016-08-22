package by.it.kisel.JD01_02;

import java.util.Scanner;

public class Util {
    static public String getLineConsole() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        return line;
    }

    static public int[] getIntArray(String line) {
        String arrStr[] = line.split(" ");
        int result[] = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            result[i] = Integer.parseInt(arrStr[i]);
        }
        return result;
    }


}