package by.it.voronovich.JD02_05.Task_B;

import by.it.voronovich.JD02_05.Util.Properties;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {

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
    }
}
