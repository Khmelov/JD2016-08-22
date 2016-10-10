package by.it.opiga.JD01_15;

import java.io.*;
                /*комментарий 4*/
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by Asus on 05.10.2016.
 */
public class TaskB {
    // комментраий 1
    public static int numstr = 1;

    public static void main(String[] arg) {
            /*комментарий
            *на
            * несколько
            * строк*/
        String src = System.getProperty("user.dir");
        String fileRead = src + "\\src\\by\\it\\opiga\\JD01_15\\TaskB.java";
        String fileWrite = src + "\\src\\by\\it\\opiga\\JD01_15\\TaskB.txt"; //комментраий 2
        Pattern p = Pattern.compile("([/][/].*)|([/][*].*[*][/])");
        Pattern p2 = Pattern.compile("([/][*].*)");
        Pattern p3 = Pattern.compile("([*].*)");
        Pattern p4 = Pattern.compile("([.]*[*][/])");

        StringBuffer strBl = new StringBuffer();
        //комментраий 3
        try {
            FileInputStream rs = new FileInputStream(fileRead);
            FileOutputStream rw = new FileOutputStream(fileWrite);

            BufferedReader reader = new BufferedReader(new InputStreamReader(rs)); /*   комментарий 5      */
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(rw));

            String line;
            while (reader.ready()) {
                line = reader.readLine();
                Matcher m = p.matcher(line);
                String s = m.replaceAll("");

                Matcher m2 = p2.matcher(s);
                if (m2.find()) {
                    String s2 = m2.replaceAll("");
                    strBl.append(numstr+++" "+ s2 + "\n");
                    line = reader.readLine();
                    Matcher m3 = p3.matcher(line);
                    while (m3.find()) {
                        String s3 = m3.replaceAll("");
                        strBl.append(numstr+++" "+s3 + "\n");
                        line = reader.readLine();
                        m3.reset();
                        m3 = p3.matcher(line);
                    }
                    Matcher m4 = p4.matcher(line);
                    String s4 = m4.replaceAll("");
                    strBl.append(numstr+++" "+s4 + "\n");
                } else
                    strBl.append(numstr+++" "+s + "\n");

            }
            writer.write(strBl.toString());

            System.out.println(strBl.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println("ошибка чтения/записи " + e.getMessage());
        }


    }
}