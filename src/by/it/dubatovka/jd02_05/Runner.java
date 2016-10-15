package by.it.dubatovka.jd02_05;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner implements IKeys {
    private static String getOneConsole() {
        return (new Scanner(System.in)).nextLine();
    }

    private static void hello() {
        System.out.println(Properties.getString(HELLO));
        System.out.println(Properties.getString(HOWDOYOUDO));
        System.out.println(Properties.getString(USER));
    }

    public static void main(String[] args) {

        if (args.length > 1) Properties.setLocale(new Locale(args[0], args[1]));

        hello();

        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date d = new Date(System.currentTimeMillis());
        System.out.println(df.format(d));

        System.out.println(LANGUAGE);
        String language;
        while (!(language = getOneConsole()).isEmpty()) {
            Locale locale = Locale.ENGLISH;
            switch (language) {
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "en":
                    locale = Locale.ENGLISH;
                    break;
                default:
                    locale = Locale.ENGLISH;
                    break;
            }
            Properties.setLocale(locale);
            hello();

//
//
//        Locale locale = new Locale("ru", "RU");
//        Properties.setLocale(locale);
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
//
//        Locale locale1 = new Locale("be", "BY");
//        Properties.setLocale(locale1);
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
//
//        Locale locale2 = new Locale("en", "EN");
//        Properties.setLocale(locale2);
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
        }
    }
}
