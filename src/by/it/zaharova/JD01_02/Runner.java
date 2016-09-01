package by.it.zaharova.JD01_02;

import java.util.Scanner;

public class Runner {

       public static void main(String[] args) {

        // write your code here
        String line = "11 1234 -1234 -11 20";
        // line=Util.getLineConsole();
        System.out.println("line=" + line);
        int mas[]=Util.getIntArray(line);
       String arrStr[]=line.split(" ");
        String maxStr=TaskA.maxLength(arrStr);
        System.out.println("Самое длинное число" + maxStr);
        System.out.println("Его длина" + maxStr.length());

        String minStr=TaskA.minLength(arrStr);
        System.out.println("Самое короткое число" + minStr);
        System.out.println("Его длина" + minStr.length());

        double mean=TaskA.mean(mas);
           System.out.println(mean);
           for (String s:arrStr)
               if(s.length()<mean)
                   System.out.print(s+" ");

           System.out.println("\nЧисло с различными цифрами " + TaskA.FindDiff(arrStr) );


           TaskB.Testing();

           TaskB.Array();

           TaskB.Yravnenie();

           TaskB.Mounth();

    }



}
