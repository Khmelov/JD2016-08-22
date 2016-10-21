package by.it.snegurskiy.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Runner0205 {

    private static String getOneConsole(){
        return (new Scanner(System.in)).nextLine();

    }

    static void hello() {

    }

    public static void main(String[] args) {
        if (args.length>1) Properties.setLocale(new Locale(args[0],args[1]));
        Locale locale=new Locale("", "");
//        Locale locale=new Locale("ru", "RU");
//        Properties.setLocale(locale);
//        System.out.println(Properties.getString("Hello"));
//        System.out.println(Properties.getString("Howdoyoudo")+"\n");
//        Properties.setLocale(new Locale("en","US"));
//        System.out.println(Properties.getString("Hello"));
//        System.out.println(Properties.getString("Howdoyoudo")+"\n");
//        Properties.setLocale(new Locale("be","BY"));
//        System.out.println(Properties.getString("Hello"));
//        System.out.println(Properties.getString("Howdoyoudo")+"\n");

        DateFormat df=DateFormat.getDateInstance(DateFormat.LONG,Properties.getLocale());
        Date d=new Date(System.currentTimeMillis());
        System.out.println(df.format(d));


        System.out.println(Properties.getString("set.Language"));
        String language;
        while (!(language=getOneConsole()).isEmpty()) {
            switch (language) {
                case "be":
                    locale = new Locale("be", "BY");
                    break;
                case "ru":
                    locale = new Locale("ru", "RU");
                    break;
                case "en":
                    locale = new Locale("en", "US");
                    break;
            }
        }

    }
}
