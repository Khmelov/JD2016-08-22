package by.it.snegurskiy.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by snegurskiy.nn on 23.09.2016.
 */
public class B15 {
    public static void B1 () throws FileNotFoundException {
        String src=System.getProperty("user.dir")+"/src/by/it/snegurskiy/";
        String filename = src+"jd01_15/B15.java";
        String filename2 = src+"jd01_15/B15.txt";
        File f=new File(filename);
        File f2=new File(filename2);
        String line;
        StringBuilder s =new StringBuilder();// создаем StringBuilder
       try (BufferedReader textB15=new BufferedReader(new FileReader(filename))){
            while ((line=textB15.readLine())!=null){
                s.append(line+"\n");
            }
           StringBuilder tmp=new StringBuilder(s);
           Pattern p=Pattern.compile("/{2}.+");
           Matcher m=p.matcher(tmp);
           int pos=0;
           while (m.find(pos)){
               tmp.delete(m.start(),m.end());
               pos=m.start();

           }
           Pattern p1=Pattern.compile(".+\n");
           Matcher m1=p1.matcher(tmp);
           int col=1;
            while (m1.find()){
                System.out.printf("%02d   %s",col,m1.group());
                col++;

           }


//           try (PrintWriter printer= new PrintWriter(new FileWriter(f2))) {
//               for (String retval : tmp.split("\n")) {
//                   System.out.println(retval);
//               }
//               }
//            catch (IOException e) {
//               e.printStackTrace();
//           }

        } catch (IOException e) {
            e.printStackTrace();// Выводим информацию об ошибках
        }
    }
}
