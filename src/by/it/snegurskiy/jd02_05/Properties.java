package by.it.snegurskiy.jd02_05;


import java.util.Locale;
import java.util.ResourceBundle;

public class Properties {
    private static Locale locale= Locale.ENGLISH;
    private static ResourceBundle resourceBundle=setLocale(locale);
    public static ResourceBundle setLocale(Locale locale){
        Properties.locale=locale;
        resourceBundle=ResourceBundle.getBundle("by.it.snegurskiy.jd02_05.Txt",locale);
        return resourceBundle;
    }
    public static String getString(String key){
        return resourceBundle.getString(key);
    }

    public static Locale getLocale() {
        return locale;
    }
}
