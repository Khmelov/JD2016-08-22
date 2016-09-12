package by.it.opiga.JD01_03;

/**
 * Created by Asus on 29.08.2016.
 */
import java.util.Scanner;


    public class InOut {
        protected static double[] stringLineVDoubleArray() {
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

        protected static void ArrayPrint(double[] mas, String name, int colCount) {
            int currentCol = 0;
            for (int i = 0; i < mas.length; i++) {
                System.out.printf("%s[% -3d]= %-8.3f ", name, i, mas[i]);
                currentCol++;
                if (currentCol % colCount == 0)
                    System.out.println();
            }
            System.out.println();
        }

        protected static void ArrayPrintTwo(double[][] mas, String name) {
            int currentCol = 0;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    System.out.printf("%s[% -3d][% -3d] = %-8.3f ", name, i, j, mas[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        protected static void PrintArray(double[][] mas) {
           for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    System.out.printf("%-8.3f ", mas[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }