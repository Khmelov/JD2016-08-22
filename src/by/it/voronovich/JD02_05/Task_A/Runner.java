package by.it.voronovich.JD02_05.Task_A;

import by.it.voronovich.JD02_05.Util.Properties;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {

        if (args.length == 2) {
            Properties.setLocale(new Locale(args[0], args[1]));
        }
        System.out.println(Properties.getString("hi"));
        System.out.println(Properties.getString("name"));
        System.out.println(Properties.getString("whatsup"));
    }
}
