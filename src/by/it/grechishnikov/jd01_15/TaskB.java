package by.it.grechishnikov.jd01_15;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Evgeniy on 23.09.16.
 */
public class TaskB {
    static void run() {
        System.out.println("TaskB. Удаляем комментарии.");
        StringBuilder string = new StringBuilder(); //first
        String path = System.getProperty("user.dir")  + "/src/by/it/grechishnikov/jd01_15" + "/TaskB.java";
        String newPath = path.substring(0, path.length() - 4) + "txt";
        /*
        second
         */
        int count = 0;//локальная переменная видна только в методе run
        //1
        /* */
        try(BufferedReader reader = new BufferedReader(new FileReader(path));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newPath))) {
            String test = "aa"; // forth
            while(reader.ready()) {
                count++;
                String tmp = " " + reader.readLine();
                String line = count >=0 && count < 10 ? "0" + count + tmp + "\n" : count + tmp + "\n";
                string.append(line);
            }
            deleteComment(string); //Удаление комментария
            writer.write(string.toString());
            System.out.println(string);/* */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteComment(StringBuilder string) {
        Pattern pattern = Pattern.compile("([/**]{2,3}[ \\n]+)([a-zA-Z0-9.* \\n]+)([/]{1})");
        Matcher matcher = pattern.matcher(string);
        int firstCount = countSimbol(string, true);
        int secondCount = countSimbol(string, false);
        for (int i = 0; i < firstCount; i++) {
            matcher.find();
            String s = matcher.group();
            int start = string.indexOf(s);
            int end = start + s.length();
            string.delete(start, end);
        }
        pattern = null;
        pattern = Pattern.compile("([/]){2}.+");
        matcher = pattern.matcher(string);
        for (int i = 0; i < secondCount; i++) {
            matcher.find();
            String s = matcher.group();
            int start = string.indexOf(s);
            int end = start + s.length();
            string.delete(start, end);
            // f
        }
    }

    private static int countSimbol(StringBuilder text, boolean big) {
        int count = 0;
        if(big) {
            int index = 0;
            while(true) {
                index = text.indexOf("*/", index + 1);
                if(index != -1) {
                    count++;
                } else {
                    break;
                }
            }
            count--;
        } else {
            int index = 0;
            while(true) {
                index = text.indexOf("//", index + 1);
                if(index != -1) {
                    count++;
                } else {
                    break;
                }
            }
            count--;
        }
        return count;
    }
}