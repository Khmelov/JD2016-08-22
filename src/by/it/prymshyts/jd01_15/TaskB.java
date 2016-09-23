package by.it.prymshyts.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * javadoc
 */

public class TaskB {

    static String testStr_1 = "тестовая строка //номер 1";
    static String testStr_2 = "тестовая строка /*" +
            "номер 2*/";

    /*Просто ещё несколько комментариев*/

    static void t1() {
        String pathToFile = System.getProperty("user.dir") + "/src/by/it/prymshyts/jd01_15";
        String fileName = "TaskB";
        StringBuilder sb = new StringBuilder(); // Однострочный комментарий

        /*
        Двухстрочный
        комментарий
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile + "/" + fileName + ".java"))){

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }

        } catch (Exception e) {
            System.err.println(e);
        }

        Pattern pattern = Pattern.compile("(\".+\")|(//.+)|(/\\*[\\s\\nа-яА-ЯёЁ\\w]*\\*/)|(/\\*\\*[\\s\\n*а-яА-ЯёЁ\\w]*/)");
        Matcher matcher = pattern.matcher(sb);

        int pos = 0;
        while (matcher.find(pos)) {
            if (matcher.group(2) != null || matcher.group(3) != null || matcher.group(4) != null) {
                sb.delete(matcher.start(), matcher.end());
                pos = matcher.start();
            } else {
                pos = matcher.end();
            }
        }

        try (FileWriter writer = new FileWriter(pathToFile + "/" + fileName + ".txt")) {
            writer.write(sb.toString());
        } catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(sb.toString());
    }
}