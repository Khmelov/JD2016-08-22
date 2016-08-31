package by.it.snegurskiy.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 26.08.2016.
 */
public class InOut {

    protected static double[] stringToDoubleOneArray() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        line.trim();
        String strMas[] = line.split(" ");
        double out[] = new double[strMas.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = Double.parseDouble(strMas[i]);
        }
        return out;
    }

    protected static double[][] stringToDoubleTwoArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк:");
        int colString=scanner.nextInt();
        System.out.println("Введите количество столбцов:");
        int colColumns=scanner.nextInt();
        double out [][]=new double[colString][colColumns];
        for (int i = 0; i <colString ; i++) {
            System.out.println("Введите "+ colColumns+ " элементов " + (i+1) +" строки ");
            for (int j = 0; j <colColumns ; j++) {
                out [i] [j]=scanner.nextDouble();}
             }
            return out;
        }




    static protected void arrayOnePrint(double mas[], String name, int colCount) {
        int currentCol = 0;
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("%s[% -3d]=%-4.2f ", name, i, mas[i]);
            currentCol++;
            if (currentCol % colCount == 0)
                System.out.println();
        }
        System.out.println();
    }

    static protected void arrayTwoPrint(double mas[][], String name, int colCount) {
        int currentCol = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.printf(name+"[% -1d][% -1d]=%-6.1f ", i,j, mas[i][j]);
                currentCol++;
                if (currentCol % colCount == 0)
                    System.out.println();
            }
            System.out.println();
        }

    }
}
