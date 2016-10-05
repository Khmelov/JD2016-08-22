package by.it.prymshyts.jd02.jd02_05;

import by.it.prymshyts.jd01.jd01_02.Util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {

    public static void main(String[] args) {
        if (args.length == 2) {
            Properties.setLocale(new Locale(args[0], args[1]));
        }

        showHello();
        showDate();

        String lan;
        do {
            System.out.print(Properties.getString("language") + ":");
            lan = Util.getConsoleLine();

            switch (lan) {
                case "en":
                    Properties.setLocale(new Locale("en"));
                    break;
                case "ru":
                    Properties.setLocale(new Locale("ru", "RU"));
                    break;
                case "be":
                    Properties.setLocale(new Locale("be", "BY"));
                    break;
            }

            if (!lan.isEmpty()) {
                showHello();
            }

        } while (!lan.isEmpty());
    }

    private static void showHello() {
        System.out.println(Properties.getString("welcome"));
    }

    private static void showDate() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Properties.getLocale());
        Date date = new Date(System.currentTimeMillis());

        System.out.println(dateFormat.format(date));
    }
}
