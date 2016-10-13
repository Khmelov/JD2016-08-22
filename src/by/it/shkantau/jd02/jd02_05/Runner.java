package by.it.shkantau.jd02.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Runner {

    private static final String HELLO = "hello";
    private static final String USER = "user";
    private static final String HELLOWORLD = "helloworld";
    private static final String SET_LANGUAGE = "set.language";

    public static void main(String[] args) {

        if (args.length > 1){
            Properties.setLocale(new Locale(args[0], args[1]));
        }

        System.out.println(Properties.getString(HELLO));
        System.out.println(Properties.getString(USER));
        System.out.println(Properties.getString(HELLOWORLD));

        System.out.println();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date data = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(data));

        System.out.println();
        System.out.println(Properties.getString(SET_LANGUAGE));
        String language;
        Locale locale;

        while (!(language = readLine()).isEmpty());
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
                default: locale = Locale.getDefault();
            }
        Properties.setLocale(locale);
        hello();


    }

    private static String readLine(){
        return new Scanner(System.in).nextLine();
    }
    private static void hello(){
        System.out.println(Properties.getString(HELLO));
    }
}
