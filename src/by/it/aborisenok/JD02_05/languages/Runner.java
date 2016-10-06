package by.it.aborisenok.JD02_05.languages;

import by.it.akhmelev.jd01_06.Level_A.Data;
import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Лёша on 05.10.2016.
 */
public class Runner implements IKeys{

   static String getOneConsole(){
        return (new Scanner(System.in)).next();
    }

    static void hello(){
        System.out.println(Properties.getString(HELLO));
        System.out.println(Properties.getString(HOWDOYOUDO));
        System.out.println(Properties.getString(USER));
        DataFormat df = DateFormat.getDateInstance(DateFormat.LONG, Properties.)
    }


    public static void main(String[] args) {
        if (args.length > 2)
            Properties.setLocale(new Locale(args[0], args[1]));
        hello();

        System.out.println(Properties.getString(LANGUAGE));
        String language;
        while (!(language = getOneConsole()).isEmpty()){
            if (language.equals("be")){
                Locale locale = new Locale("be","BY");
            } else
            if (language.equals("ru")){
                Locale locale = new Locale("ru","RU");
            } else
            if (language.equals("en")){
                Locale locale = new Locale("en");
            }
            Properties.setLocale(l)
        }
//немного допилить
        //если пусто локаль инглиш
//        Properties.setLocale(new Locale("be", "BY"));
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
//        System.out.println();
//
//
//        Properties.setLocale(new Locale("ru", "RU"));
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
//        System.out.println();
//
//        Properties.setLocale(new Locale("en", "RU"));
//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString(USER));
//        System.out.println();
//

    }
}
