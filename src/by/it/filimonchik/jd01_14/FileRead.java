package by.it.filimonchik.jd01_14;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Raman.Filimonchyk on 26/09/2016.
 */
public class FileRead {
    public static void A2() throws Exception{
String src=System.getProperty("user.dir")+"/src/by/it/filimonchik/";
        String filename=src+"jd01_14/ReadFile.txt";
        File file = new File(filename);
        int b, count=0;
        FileReader is = null;
        try {
            is=new FileReader(file);
            while ((b=is.read()) !=-1){
                System.out.print((char)b);
                count++;
            }
        }catch (IOException e){
            System.out.println("Ошибка файла: "+e);
        }
        finally {
            try {
                if(is !=null){
                    is.close();
                }
            }catch (IOException e){
                System.out.println("Ошибка закрытия: "+e);}
        }
    }
}
