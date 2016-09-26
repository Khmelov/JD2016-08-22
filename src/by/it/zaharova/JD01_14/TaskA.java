package by.it.zaharova.JD01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws IOException {

        String src = "D:/work/Vlada Zaharova/JD2016-08-22/src/by/it/zaharova/";
        String filename = src + "JD01_14/integer.dat";
        File f = new File(filename);

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет: " + filename);
        } finally {
            if (dos != null) {
                dos.close();
            }
        }

        try (DataInputStream inp = new DataInputStream
                (new BufferedInputStream
                        (new FileInputStream(filename))
                )
        ) {
            double sum = 0;
            double count = 0;
            int i = 0;
            while (inp.available() > 0) {
                i = inp.readInt();
                sum += i;
                count++;
            }
            System.out.println("Среднее арифметическое = " + sum / count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
