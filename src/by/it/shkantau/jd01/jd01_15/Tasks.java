package by.it.shkantau.jd01.jd01_15;


import by.it.shkantau.jd01.jd01_15.commander.Commander;

import java.io.*;
import java.util.Arrays;
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

        Thread thread = new Thread();
    }

    static void  taskB() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(System.getProperty("user.dir") +File.separator +  "src/by/it/shkantau/jd01_12/Task12A.java");
        if (file.exists()){
            String line;
            try(BufferedReader br = new BufferedReader(new FileReader(file))) {
                while ((line = br.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
                return;
            }
        }
        commentsRemover(sb.toString()); // don't work!!

        String newPath = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".txt";
        File newFile = new File(newPath);

        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newFile))){
            String str = sb.toString();
            String [] strings = str.split("\n");
            for (int i = 0; i < strings.length; i++) {
                System.out.printf("%02d %s\n", i, Arrays.toString(strings[i].getBytes()));
//                for (int j = 0; j < strings[i].length(); j++) {
//                    System.out.print((int)strings[i].charAt(j));
//                }
//                System.out.println();

                bufferedOutputStream.write(String.format("%02d",i).getBytes());
                bufferedOutputStream.write(strings[i].getBytes());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file Exception "+ newFile.getName());
        }
    }

    static void taskC(String intDir) throws IOException {

         Commander cmd = new Commander(intDir);
         Scanner scanner = new Scanner(System.in);
         String readString;

         System.out.println("Welcome to simple commander. To exit type \"\\q\"");
         cmd.printPath();
         while(true) {
             readString = scanner.nextLine();
             if (readString.equals("\\q")) {
                 break;
             } else {
                 cmd.setCommand(readString);
             }
         }
    }

    private static StringBuilder generatePrintMatrix(int dimension , int min, int max){
        int [][] matrix = new int[dimension][dimension];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            String line = "";
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = (int)((max - min) * Math.random()) + min;
                line += String.format("%03d ", matrix[i][j]);
            }

            System.out.println(line);
            stringBuilder.append(line);
            stringBuilder.append("\n");

        }
        return stringBuilder;
    }

    private static String commentsRemover(String string){
        

        return null;
    }



}
