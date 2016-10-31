package by.it.opiga.JD02_05.TaskA;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Asus on 05.10.2016.
 */
public class Runner implements Keys {
    public static String getOneConsole() {
        return (new Scanner(System.in)).nextLine();
    }

    public static void Hello() {
        System.out.println(Properties.getString(HELLO));
        System.out.println(Properties.getString(USER));
        System.out.println(Properties.getString(HOWDOYOUDO));


    }

    public static void main(String[] arg) {

        if (arg.length == 2)
            Properties.setLocale(new Locale(arg[0], arg[1]));
        else if (arg.length == 0)
            Properties.setLocale(new Locale("en"));
        // Locale locale=new Locale("be","BY");//создана локаль, но не подключится руссский
        //Properties.setLocale(locale);//а теперь подключится
        Hello();
        System.out.println(Properties.getString(SETLANGUAGE));
        String lang;
        while (!(lang = getOneConsole()).isEmpty()) {
            Locale locale = Locale.ENGLISH;
            switch (lang) {
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "en":
                    locale = new Locale("en");
                    break;
            }
            Properties.setLocale(locale);
        }
        Hello();
    }
}
