package by.it.snegurskiy.jd01_15;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by snegurskiy.nn on 25.09.2016.
 */
public class C15 {
    public static  void C1 () {
        File f=new File(System.getProperty("user.dir")+"/src/by/it/");
        File[] files = f.listFiles();
        for (int i = 0; i <files.length ; i++) {
            System.out.println(files[i]);
        }


    }
}
