package by.it.grechishnikov.jd01_15;

import java.io.*;

public class TaskA {
    static void run() {
        String path = System.getProperty("user.dir")  + "/src/by/it/grechishnikov/jd01_15" + "/test1.txt";
        int[][] matrix = new int[4][4];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < matrix.length; i++) {
                String line = "";
                for (int j = 0; j < matrix[i].length; j++) {
                    int tmp = (int) (Math.random() * 30 - 15);
                    matrix[i][j] = tmp;
                    line += String.format("%3d ", tmp);
                }
                line += "\n";
                System.out.print(line);
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
