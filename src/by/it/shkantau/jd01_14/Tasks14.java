package by.it.shkantau.jd01_14;

import java.io.*;
import java.util.Scanner;

class Tasks14 {

     static void taskA() throws IOException {
        int arraySize = 20;

        String fileName = "/home/duch/IdeaProjects/JD2016-08-22/src/by/it/shkantau/jd01_14/TaskA.dat";
        File file = new File(fileName);
// File creation
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (int i = 0; i < arraySize; i++) {
                dos.writeInt((int)(Math.random()*100));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file Exception "+ fileName);
        }
// File reading
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            int mean = 0, count = 0;
            while(dis.available() > 0){
                mean += dis.readInt();
                count++;
            }
            System.out.println("mean = "+(double)mean/(double) count);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public static void taskB() throws FileNotFoundException {
        String fileName = "/home/duch/IdeaProjects/JD2016-08-22/src/by/it/shkantau/jd01_14/TaskB.txt";
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int punctCounter = 0, wordsCounter = 0;
        while (scanner.hasNext("\\p{Punct}")){
            punctCounter++;
        }

        scanner.useDelimiter("\\b");
//        scanner.reset()

    }

}
