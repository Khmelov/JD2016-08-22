package by.it.prymshyts.jd01_14;

import java.io.File;
import java.util.LinkedList;

public class TaskC {

    static void t1() {
        File f = new File(System.getProperty("user.dir"));

        try {
            File[] content = f.listFiles();
            LinkedList<String> catalogList = new LinkedList<>();
            LinkedList<String> fileList = new LinkedList<>();

            for (int i = 0; i < content.length; i++) {
                if (content[i].isFile()) {
                    fileList.add(content[i].getName());
                } else {
                    catalogList.add(content[i].getName());
                }
            }

            System.out.println("Список каталогов:");
            for (String str : catalogList) {
                System.out.println(" • " + str);
            }

            System.out.println("\nСписок файлов:");
            for (String str : fileList) {
                System.out.println(" - " + str);
            }

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }
}
