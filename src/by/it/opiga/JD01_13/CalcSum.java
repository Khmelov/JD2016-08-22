package by.it.opiga.JD01_13;

import java.util.ArrayList;

/**
 * Created by Asus on 04.10.2016.
 */
public class CalcSum {
    private static double sum=0;
    private static int num = 0;
    private static ArrayList<Integer> arr = new ArrayList<>();
    public static void calcSum(String s) throws NumberFormatException
    {
        num = Integer.parseInt(s);
        arr.add(num);
        sum += Math.sqrt(num);
        System.out.println("Число: " + num + "\nсумма корней ранее введеных чисел: " + sum);
    }

}
