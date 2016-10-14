package by.it.aborisenok.JD02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by aborisenok on 10.10.2016.
 */
public class Utils {
    public static String readLanguage(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        return str;
    }

    public static void printInformation(String language){
        Locale locale = new Locale(language);
        Properties.setLocale(locale);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
        Date date = new Date();
        System.out.println(Properties.getString("language"));
        System.out.println(Properties.getString("hello") + " " + Properties.getString("user"));
        System.out.println(Properties.getString("howdoyoudo"));
        System.out.println(Properties.getString("time") + " " + dateFormat.format(date));
        System.out.println();
    }
}
