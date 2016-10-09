package by.it.kisel.JD02_05;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 05.10.2016.
 */
public class Runner implements IKeys {


    static String getOneConsole(){
        return (new Scanner(System.in)).nextLine();
    }

    static void hello(){
        System.out.println(Properties.getString(HELLO));
        System.out.println(Properties.getString("whatsup"));
        System.out.println(Properties.getString(USER) + "\n");
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date d=new Date(System.currentTimeMillis());
        System.out.println(df.format(d));
    }

    public static final String USER = "user";

    public static void main(String[] args) {

        if(args.length==2)
            Properties.setLocale(new Locale(args[0],args[1]));


//        Properties.setLocale(new Locale("be", "BY"));
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString("whatsup"));
//        System.out.println(Properties.getString(USER) + "\n");
//
//        Locale locale = new Locale("ru", "RU");
//        Properties.setLocale(locale);
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString("whatsup"));
//        System.out.println(Properties.getString(USER) + "\n");



        System.out.println(Properties.getString(LANGUAGE));
        String language;
        while (!(language=getOneConsole()).isEmpty()){
            Locale locale = Properties.getLocale();
            if (language.equals("be")){
               locale = new Locale("be","BY");
            }
            else if (language.equals("ru")){
                locale = new Locale("ru","RU");
            }
            else if (language.equals("en")){
                locale = Locale.ENGLISH;
            }
            Properties.setLocale(locale);
            hello();
        }


    }
}
