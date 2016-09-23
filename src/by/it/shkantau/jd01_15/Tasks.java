package by.it.shkantau.jd01_15;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

 class Tasks {
    private static final int SQUARE_MATRIX_DIMENSION = 4;
    private static final int MIN_VALUE = -15;
    private static final int MAX_VALUE = 15;

     static void taskA()  {
        StringBuilder sb = generatePrintMatrix(SQUARE_MATRIX_DIMENSION , MIN_VALUE, MAX_VALUE);
        String src = System.getProperty("user.dir") + "/src/by/it/shkantau/jd01_15/matrix.txt";

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(src) )){
            bufferedWriter.append(sb);
            bufferedWriter.flush();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }


     static void taskC(String intDir) throws IOException {
        File file = new File(intDir);
        String readString, pathStr = intDir;
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        if (file.exists()){
            System.out.println("Welcome to simple commander. To exit type \"\\q\"");
            System.out.println(pathStr);
            while(true){
                readString = scanner.nextLine();
                if(readString.equals("\\q")){
                    break;
                }else {
                    readString = readString.trim();
                    if(readString.startsWith("dir")){
                        String [] files = file.list();
                        File tmpFile;
                        for (String fileName: files) {
                            if (fileName != null){
                                Path path = Paths.get(pathStr + "/" + fileName);
                                if (Files.exists(path)){

                                    System.out.println(fileName + "\t");
                                }

                            }

                        }

                    }

                }
            }


        }else{
            System.out.println("Wrong path");
        }


    }

    private static StringBuilder generatePrintMatrix(int dimension , int min, int max){
        int [][] matrix = new int[dimension][dimension];
        StringBuilder stringBuilder = new StringBuilder();
        String line ;
        for (int i = 0; i < dimension; i++) {
            line = "{";
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = (int)((max - min) * Math.random()) - min;
                line += matrix[i][j];
                if (j != dimension - 1){
                    line += ",";
                }
            }
            line += "}";
            System.out.println(line);
            stringBuilder.append(line + "\n");

        }
        return stringBuilder;
    }


}
