package by.it.snegurskiy.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by user on 24.08.2016.
 */
public class Util {

    static public String getOnLine () throws IOException {

        BufferedReader stin = new BufferedReader( new InputStreamReader(System.in));
        System.out.println("type the text");
        String line=stin.readLine();
        stin.close();
        return line;
        }

    static public String getLineConsole (){
        Scanner scanner=new Scanner(System.in);
        System.out.println("type the text");
        String line=scanner.nextLine();
        return line;
    }

    static public int getIntConsole (){
        Scanner scanner=new Scanner(System.in);
        int line=scanner.nextInt();
        return line;
    }

    static public double getDoubleConsole (){
        Scanner scanner=new Scanner(System.in);
        double line=scanner.nextDouble();
        return line;
    }



    static public int [] getIntArray (String line){
        String strMas [] = line.split(" ");
        int[] intMas = new int[strMas.length];
        for (int j = 0; j < strMas.length; j++) {
            intMas[j] = Integer.parseInt(strMas[j]);
            //System.out.println(intMas[3]);
            }

        return intMas;
    }
}
