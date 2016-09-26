package by.it.prymshyts.jd01.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static void t1() {
        File f = new File(System.getProperty("user.dir") + "/src/by/it/prymshyts/jd01_14/text.txt");

        try (BufferedReader file = new BufferedReader(new FileReader(f))) {
            StringBuilder sb = new StringBuilder();
            String line = file.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = file.readLine();
            }

            Pattern punctPattern = Pattern.compile("[.]|[,]|[:]|[;]|[-]|[!]|[?]");
            Pattern wordPattern = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcher = punctPattern.matcher(sb);
            int punct = 0, words = 0;

            while (matcher.find()) {
                punct++;
            }

            matcher.reset();
            matcher.usePattern(wordPattern);

            while (matcher.find()) {
                words++;
            }

            System.out.println("Число знаков препинания: " + punct);
            System.out.println("Число слов: " + words);

        } catch (IOException e) {
            System.err.println("ошибка: " + e);
        }
    }
}