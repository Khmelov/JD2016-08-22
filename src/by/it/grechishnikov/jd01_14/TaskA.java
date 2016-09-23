package by.it.grechishnikov.jd01_14;

import java.io.*;


public class TaskA {
    static void run() {
        System.out.println("TaskA");
        String path = System.getProperty("user.dir") + "/src/by/it/grechishnikov/jd01_14" + "/test1.txt";
        try(DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path))))
        {
            for (int i = 0; i < 20; i++) {
                int tmp = (int) (Math.random() * 10);
                outputStream.writeInt(tmp);
            }
            outputStream.flush();
            int sum = 0, count = 0;
            while(inputStream.available() > 0) {
                int tmp = inputStream.readInt();
                sum += tmp;
                count++;
                System.out.println(tmp);
            }
            System.out.printf("Среднее арифметическое = %d, количество чисел = %d, сумма = %d\n", (sum / count), count, sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
