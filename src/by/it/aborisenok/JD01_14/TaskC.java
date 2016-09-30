package by.it.aborisenok.JD01_14;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by aborisenok on 29.09.2016.
 */
public class TaskC {
    static ArrayList<String> dirList = new ArrayList<>();
    static ArrayList<String> fileList = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }
    public static void run(){
        String src = System.getProperty("user.dir");
        File file = new File(src);
        projectFileList(src);
        System.out.println("Список директорий : ");
        printer(dirList);
        System.out.println("Список файлов : ");
        printer(fileList);
    }

    public static void projectFileList(String src){
        File file = new File(src);

        for (File files : file.listFiles()){
            if (files.isDirectory()){
                dirList.add(files.getName());
                projectFileList(files.getAbsolutePath());
            } else {
                fileList.add(files.getName());
            }
        }
    }

    public static <T> void printer(ArrayList<T> arrayList){
        int count = 0;
        for (T element : arrayList){
            if (count < 10){
                System.out.print(element + ", ");
                count++;
            }else {
                System.out.print("\n" + element + ", ");
                count = 1;
            }
        }
        System.out.println("\n*************************************\n");
    }


}
