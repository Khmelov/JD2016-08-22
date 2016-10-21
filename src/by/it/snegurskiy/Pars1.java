package by.it.snegurskiy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Acer on 19.10.2016.
 */
public class Pars1 {
    public static void main(String[] args) {
        String filename = "C:/Users/Lenovo/Desktop/all1.txt";
        File f = new File(filename);
        String line;
        String text;
        int pos=0;
        StringBuilder s = new StringBuilder();// создаем StringBuilder
        try (BufferedReader textB15 = new BufferedReader(new FileReader(filename))) {
            while ((line = textB15.readLine()) != null) {
                s.append(line + "\n");
            }
            StringBuilder tmp = new StringBuilder(s);
            Pattern p = Pattern.compile("'.+\n");
            Matcher m = p.matcher(tmp);
            while (m.find(pos)) {
                text=m.group();
                tmp.delete(m.start(),m.end()-1);
                pos=m.start();


            }
            System.out.println(tmp.toString());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}