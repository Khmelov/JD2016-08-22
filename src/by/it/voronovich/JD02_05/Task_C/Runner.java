package by.it.voronovich.JD02_05.Task_C;

import by.it.voronovich.JD02_05.Util.Properties;

import java.text.DateFormat;
import java.util.*;

public class Runner {

    static String getOneConsole() {
        return (new Scanner(System.in)).nextLine();
    }

    static void hello() {
        System.out.println(Properties.getString("hi"));
        System.out.println(Properties.getString("name"));
        System.out.println(Properties.getString("whatsup") + "\n");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date date = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date)+"\n");
        System.out.println(Properties.getString("inputlanguage")+"\n");
    }

    public static void main(String[] args) {

        if (args.length == 2) {
            Properties.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(Properties.getString("hi"));
        System.out.println(Properties.getString("name"));
        System.out.println(Properties.getString("whatsup")+"\n");

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date date = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date));

        System.out.println(Properties.getString("inputlanguage")+"\n");
        String language;
        while(!(language=getOneConsole()).isEmpty()){

                switch (language) {
                    case "be":
                        Properties.setLocale(new Locale("be", "BY"));
                        hello();
                        break;
                    case "ru":
                        Properties.setLocale(new Locale("ru", "RU"));
                        hello();
                        break;
                    case "en":
                        Properties.setLocale(Locale.ENGLISH);
                        hello();
                        break;
                }
        }
    }
}
