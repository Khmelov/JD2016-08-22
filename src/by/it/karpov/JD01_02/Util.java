package by.it.karpov.JD01_02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {
    static String getOneLine() throws IOException{
        BufferedReader str=new BufferedReader(new InputStreamReader(System.in));
        String line=str.readLine();
        str.close();
        return line;
    }

    static int[] strToArray(String line)
    {
        String[] strArray=line.split(" ");
        int[] array=new int [strArray.length];
        for (int j = 0; j <strArray.length ; j++) {
            array[j]=Integer.parseInt(strArray[j]);
        }
        return array;
    }

    private static Scanner sc = null;

    public static int getNumber() {
        int count = 0;
        int n=0;
        int m=0;
        if (sc == null)
            sc = new Scanner(System.in);
        System.out.println("Начало уровня B. \nЗадание №1.");
        try {
            System.out.print("введите k (целое положительное число)\n-> ");
            count = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        return count;
    }
}
