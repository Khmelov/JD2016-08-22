package by.it.prymshyts.jd01.jd01_14;

import by.it.prymshyts.jd01.jd01_02.Util;

import java.io.*;

public class TaskA {

    static void t1() {
        String filePath = null; // Указать путь.
        DataOutputStream fileOut = null;

        if (filePath == null) {
            System.out.print("Укажите путь для файла (путь завершить слешем, файл можно будет сразу же удалить): ");
            filePath = Util.getConsoleLine();
            filePath += ("file.dat");
        }

        try {
            fileOut = new DataOutputStream(new FileOutputStream(filePath));
            for (int i = 1; i <= 20; i++) {
                fileOut.writeInt(i);
            }
        } catch (Exception e) {
            System.out.println("файл не смог открыться");
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException e) {
                System.out.println("файл не смог закрыться");
            }
        }

        DataInputStream fileIn = null;

        try {
            fileIn = new DataInputStream(new FileInputStream(filePath));
            while (fileIn.available() > 0) {
                int i = fileIn.readInt();
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("файл не смог открыться");
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
            } catch (IOException e) {
                System.out.println("файл не смог закрыться");
            }
        }

        System.out.print("Удалить файл: Y/N?\n>> ");
        char answer = Util.getConsoleLine().toLowerCase().toCharArray()[0];

        if (answer == 'y') {
            File f = new File(filePath);
            if (f.exists() && f.delete()) {
                System.out.println("Файл удалён.");
            }
        }
    }
}
