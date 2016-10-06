package by.it.grechishnikov.jd02_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Runner {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Введите en, ru или be. Пустая строка завершает программу.");
            String command = "";
            try {
                command = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (command.isEmpty()) {
                break;
            }
            Locale locale = null;
            switch (command) {
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                case "en":
                    locale = new Locale("en", "EN");
                    break;
            }
            String path = "by.it.grechishnikov.jd02_05.hello";
            ResourceBundle bundle = ResourceBundle.getBundle(path, locale);
            System.out.println(bundle.getString("hello") + ", " + bundle.getString("name") + "!");
            DateFormat format = DateFormat.getDateInstance(DateFormat.LONG, locale);
            System.out.println(format.format(new Date()));
            NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
            System.out.println("Форматируем число 1000000 = " + numberFormat.format(1000000));

        }
        try {
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
