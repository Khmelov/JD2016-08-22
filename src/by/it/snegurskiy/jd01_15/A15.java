package by.it.snegurskiy.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by snegurskiy.nn on 23.09.2016.
 */
public class A15 {
    public static void A1 () {
        int [][] mas=new int[4][4];
        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas[0].length ; j++) {
                mas[i][j]=(int) (Math.random()*30-15);
            }
        }
        for (int i = 0; i <mas.length ; i++) {
            System.out.println();
            for (int j = 0; j <mas[0].length ; j++) {
                System.out.printf("% 4d",mas[i][j]);
            }
        }
        String src=System.getProperty("user.dir")+"/src/by/it/snegurskiy/";
        String filename = src+"jd01_15/matrix.txt";
        File f=new File(filename);
        try (PrintWriter printer= new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i <mas.length ; i++) {
                printer.println();
                for (int j = 0; j < mas[0].length; j++) {
                    printer.printf("% 4d",mas[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
