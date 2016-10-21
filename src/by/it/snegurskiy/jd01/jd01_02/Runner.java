package by.it.snegurskiy.jd01.jd01_02;


import java.lang.*;

/**
 * Created by user on 24.08.2016.
 */
public class Runner {
    public static void main (String [] args) {

        //String line=Util.getOnLine();

        String line = "11 22 -22 333 -333 1";
        //String line= Util.getLineConsole();
        System.out.println("OUT=" + line);

        int arr[] = Util.getIntArray(line);
        //for (int i : arr) {
        //    System.out.println(i + " ");
        //}
        String strMas [] = line.split(" ");
        System.out.println("Самое длинное число"+A.maxLength(strMas));
        //System.out.println("Его длина" +strMas.length());
        System.out.println("Самое короткое число"+A.minLength(strMas));
        //System.out.println("Его длина" +strMas.length());


        double mean=A.mean(arr);
        System.out.println(mean);

        for (String s:strMas)
            if (s.length()<mean)
                System.out.println(s+" ");

    }

    }
