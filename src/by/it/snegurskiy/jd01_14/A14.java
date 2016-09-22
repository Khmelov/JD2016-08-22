package by.it.snegurskiy.jd01_14;

import java.io.*;

/**
 * Created by snegurskiy.nn on 21.09.2016.
 */
public class A14 {
    public static void A1() {
        String src=System.getProperty("user.dir")+"/src/by/it/snegurskiy/";
        String filename = src+"jd01_14/A";
        File f=new File(filename);
        try (BufferedOutputStream is=new BufferedOutputStream(new FileOutputStream(f))){
            for (int i = 0; i <20 ; i++) {
                is.write((int) (Math.random() * 10));
            }
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static void A2() {
        String src=System.getProperty("user.dir")+"/src/by/it/snegurskiy/";
        String filename = src+"jd01_14/A";
        File f=new File(filename);
        try (BufferedInputStream is=new BufferedInputStream(new FileInputStream(f))){
            int [] mas =new int[20];
            for (int i = 0; i <20 ; i++) {
                mas [i]=is.read();
            }
            double col=0;
            for (int i = 0; i <mas.length ; i++) {
            System.out.println(i+" element = "+mas[i]);
                col=col+mas[i];
                if (i==mas.length-1) System.out.println(col/20);
            }
        }
        catch (IOException e){
            System.out.println(e);
        }

    }

}
