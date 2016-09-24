package by.it.aborisenok.JD01_14;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by Лёша on 24.09.2016.
 */
public class TaskA {
    public static void run(){
        String src = System.getProperty("user.dir") + "\\src\\by\\it\\aborisenok\\";
        String ios = src + "JD01_14\\file.txt";
//        String ios = "D:\\JavaProjects\\JD2016-08-22\\src\\by\\it\\aborisenok\\JD01_14\\file.txt";
        writeInFile(ios);
        readFromFile(ios);
    }

    public static void writeInFile(String ios){
        try(DataOutputStream os = new DataOutputStream(new FileOutputStream(ios))) {
            for (int i = 0; i < 20; i++){
                int a = (int)(Math.random()*20);
                os.writeInt(a);
            }
        } catch (IOException e){
            System.err.println("Problems with writing");
        }
    }

    public static void readFromFile(String ios){
        ArrayList<Integer> intList = new ArrayList<>();
        int sum = 0;
        int count = 0;
        try(DataInputStream is = new DataInputStream(new FileInputStream(ios))) {
            while (is.available() > 0){
                int value = is.readInt();
                intList.add(value);
                sum += value;
                count++;
            }
        } catch (IOException e){
            System.err.println("Problems with reading");
        }
        System.out.println("Integer List - " + intList);
        System.out.println("Arithmetical mean - " + sum/count);
    }
}
