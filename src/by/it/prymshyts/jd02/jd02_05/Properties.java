package by.it.prymshyts.jd02.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

class Properties {

    private static Locale locale = Locale.ENGLISH;
    private static ResourceBundle resourceBundle = setLocale(locale);

    static ResourceBundle setLocale(Locale locale) {
        Properties.locale = locale;
        resourceBundle = ResourceBundle.getBundle("by.it.prymshyts.jd02/jd02_05.res.Resource_Bundle.text", locale);
        return resourceBundle;
    }

    static String getString(String key) {
        return resourceBundle.getString(key);
    }

    static Locale getLocale() {
        return locale;
    }
}
