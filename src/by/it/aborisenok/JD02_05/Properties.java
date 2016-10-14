package by.it.aborisenok.JD02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by aborisenok on 10.10.2016.
 */
public class Properties {
    private static Locale locale = Locale.getDefault();

    private static ResourceBundle resourceBundle = setLocale(locale);

    public static ResourceBundle setLocale(Locale locale){
        Properties.locale = locale;
        resourceBundle = ResourceBundle.getBundle("by.it.aborisenok.JD02_05.propertiesRes.text", locale);
        return resourceBundle;
    }

    public static String getString(String key){
        return resourceBundle.getString(key);
    }
}
