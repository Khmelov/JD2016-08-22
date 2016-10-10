package by.it.zaharova.JD02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by user on 05.10.2016.
 */
public class Properties {
    private static Locale locale = Locale.ENGLISH;

    public static Locale getLocale() {
        return locale;
    }

    private static ResourceBundle resourceBundle = setLocale(locale);

    public static ResourceBundle setLocale(Locale locale){
        Properties.locale = locale;
        resourceBundle=ResourceBundle.getBundle("by.it.zaharova.JD02_05.languages.words", locale);
        return resourceBundle;
    }

    public static String getString(String key){
        return resourceBundle.getString(key);
    }
}
