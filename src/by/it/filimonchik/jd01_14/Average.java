package by.it.filimonchik.jd01_14;

import java.io.*;

public class Average {
    public static void A3() throws Exception {
        String src = System.getProperty("user.dir") + "/src/by/it/filimonchik/";
        String filecreate = src + "jd01_14/Average.dat";
        File file = new File(filecreate);
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                dos.writeInt((int) (Math.random() * 20 + 20));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filecreate + " не найден.");
        } finally {
            if (dos != null) {
                dos.close();
            }
            try (DataInputStream dis=new DataInputStream
                    (new BufferedInputStream
                            (new FileInputStream(file))
                    )
            )
            {
                double sum=0;
                double count=0;
                while (dis.available()>0) {
                    int i=dis.readInt();
                    sum=sum+i;
                    count++;
                }
                System.out.println("Task A3.");
                System.out.println("Среднее арифметическое = " + sum / count + "\n");
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}