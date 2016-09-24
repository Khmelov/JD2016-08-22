package by.it.aborisenok.JD01_15;

import java.io.*;

/**
 * Created by Лёша on 24.09.2016.
 */
public class TaskA {
    public static void run(){
        int[][] matrix = matrixCreate();
        printMatrix(matrix);
    }
    private static int[][] matrixCreate(){
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = (int)((Math.random()*30)-15);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++){
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void printByteInFile(int[][] matrix){
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String os = src + "JD01_15\\matrixByte.txt";

        try(DataOutputStream writer = new DataOutputStream(new FileOutputStream(os))) {
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    writer.writeInt(matrix[i][j]);
                }
            }
        } catch (IOException e) {
            System.out.println("Writing error!");
        }
    }

    private static void printCharInFile(int[][] matrix){
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String os = src + "JD01_15\\matrixChar.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(os))) {
            for (int i = 0; i < matrix.length; i++){
                String matrixLine;
                for (int j = 0; j < matrix[0].length; j++){
                    
                }
            }
        } catch (IOException e) {
            System.out.println("Writing error!");
        }
    }
}
