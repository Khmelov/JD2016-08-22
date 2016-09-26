package by.it.kisel.JD01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws IOException {

        String src = "D:/work/Evgeny Kisel/JD2016-08-22/src/by/it/kisel/";
        String filename = src + "JD01_14/integer.dat";
        File f = new File(filename);

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(f));       // можно писать try в круглых => не нужен finally. закроется сам
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
