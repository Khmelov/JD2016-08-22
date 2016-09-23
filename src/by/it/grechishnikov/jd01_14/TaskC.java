package by.it.grechishnikov.jd01_14;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Evgeniy on 21.09.16.
 */
public class TaskC {
    static List<File> files = new ArrayList<>();
    static List<File> folders = new ArrayList<>();
    static Queue<File> storage = new ConcurrentLinkedQueue<>();

    static void run() {
        System.out.println("TaskC");
        String path = System.getProperty("user.dir");
        System.out.println("Ищем в: " + path);
        storage.add(new File(path));
        searchFileAndDir();
        System.out.println("\nКаталоги:");
        for (File f : folders) {
            System.out.println(f);
        }
        System.out.println("\nФайлы:");
        for (File f : files) {
            System.out.println(f);
        }
    }

    private static void searchFileAndDir() {
        while(!storage.isEmpty()) {
            for (File path : storage) {
                if (path.isFile()) {
                    storage.remove(path);
                    files.add(path);
                } else if (path.isDirectory()) {
                    storage.remove(path);
                    folders.add(path);
                    for (File f : path.listFiles()) {
                        storage.add(f);
                    }
                }
            }
        }
    }

    /**
     * Для оценки.
     * Читаем массив из файла.
     * Сортируем и сохраняем в другой файл.
     * Вызываем метод list()
     */
    static void dopMethod() {
        System.out.println("На оценку\n" + Arrays.toString(new File(System.getProperty("user.dir")).list()));
        String firstPath = System.getProperty("user.dir") + "/src/by/it/grechishnikov/jd01_14/test3.txt";
        String secondPath = System.getProperty("user.dir") + "/src/by/it/grechishnikov/jd01_14/test4.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(firstPath));
            FileWriter writer = new FileWriter(secondPath)) {
            int[] mass = new int[0];
            while(reader.ready()) {
                String[] arr = reader.readLine().split(" ");
                mass = new int[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    mass[i] = Integer.parseInt(arr[i]);
                }
            }
            System.out.println(Arrays.toString(mass));
            Arrays.sort(mass);
            System.out.println(Arrays.toString(mass));
            for (int i = 0; i < mass.length; i++) {
                writer.write(String.valueOf(mass[i]) + " ");
            }
        } catch (IOException e) {

        }
    }
}