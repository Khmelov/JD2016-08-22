package by.it.filimonchik.jd01_14;

import by.it.filimonchik.jd01_06.Data;

import java.io.*;

/**
 * Created by Raman.Filimonchyk on 26/09/2016.
 */
public class WriteInTheFile {
    public static void A1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/filimonchik/";
        String filecreate = src + "jd01_14/MyFirstFile.dat";
        File file = new File(filecreate);
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20+20));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filecreate + " не найден.");
        } finally {
            if (dos != null) {
                dos.close();
            }
        }
        System.out.println("Task A1.");
        System.out.println("Информация записана в файл: \"MyFirstFile.dat\""+"\n");
    }
}