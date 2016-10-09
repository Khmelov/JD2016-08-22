package by.it.opiga.JD01_15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Asus on 05.10.2016.
 */
public class TaskA {
    public static void main(String[] arg) {
        int mas[][] = new int[4][4];
        for (int i = 0; i < mas.length; i++)
            for (int j = 0; j < mas[i].length; j++)
                mas[i][j] = (int) (Math.random() * 30 - 15);


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++)
                System.out.printf("[%-3d] ", mas[i][j]);
            System.out.println();
        }
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\opiga\\JD01_15\\matrix.txt";
        try (PrintWriter print = new PrintWriter(new FileWriter(src, true))) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++)
                    print.printf("[%-3d] ", mas[i][j]);
                print.println();
            }
            print.flush();
        } catch (IOException e) {
//            throw new IOException("не выводит в файл ",e);
        }
    }

}
