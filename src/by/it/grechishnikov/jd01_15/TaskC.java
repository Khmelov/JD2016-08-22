package by.it.grechishnikov.jd01_15;

import java.io.*;

/**
 * Created by Evgeniy on 23.09.16.
 */
public class TaskC {
    static void run() {
        String path = System.getProperty("user.dir");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                System.out.println("Введите:\ncd путь - сменить директорию\ndir - вывод каталога\nend - если хотите завершить программу");
                String s = reader.readLine();
                String[] arg = s.split(" ");
                if(arg[0].equalsIgnoreCase("cd") || arg[0].equalsIgnoreCase("dir")) {
                    switch (arg[0]) {
                        case "cd" :
                            path = arg[1];
                            break;
                        case "dir":
                            File[] files = new File(path).listFiles();
                            for(File f : files) {
                                System.out.println(f.getName());
                            }
                            break;
                    }
                } else if(s.equalsIgnoreCase("end")) {
                    return;
                }
                else {
                    System.out.print("Ошибка. ");
                }
            } catch (IOException e) {
                System.out.println("Ошибка. Попробуйте еще раз");
            }
        }
    }
}