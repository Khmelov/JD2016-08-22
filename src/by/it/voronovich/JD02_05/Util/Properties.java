package by.it.voronovich.JD02_05.Util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Properties {

    private static Locale locale = Locale.ENGLISH;

    private static ResourceBundle resourceBundle = setLocale(locale);

    public static Locale getLocale() {
        return locale;
    }

    public static ResourceBundle setLocale(Locale locale) {
        Properties.locale = locale;
        resourceBundle = ResourceBundle.getBundle("by.it.voronovich.JD02_05.Util.CodeData.text", locale);
        return resourceBundle;
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }
}