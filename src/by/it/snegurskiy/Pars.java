package by.it.snegurskiy;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Acer on 19.10.2016.
 */
public class Pars {
    public static void main(String[] args) {
        System.out.println("1");
        String filename = "C:/Users/Lenovo/Desktop/all.txt";
        File f = new File(filename);
        String line;
        String text;
        StringBuilder s = new StringBuilder();// создаем StringBuilder
        try (BufferedReader textB15 = new BufferedReader(new FileReader(filename))) {
            while ((line = textB15.readLine()) != null) {
                s.append(line + "\n");
            }
            StringBuilder tmp = new StringBuilder(s);
            Pattern p = Pattern.compile("href.+>");
            Matcher m = p.matcher(tmp);
            while (m.find()) {
                text=m.group();
                text=text.substring(6);
                System.out.println(text);


            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
