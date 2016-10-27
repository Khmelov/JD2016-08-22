package by.it.opiga.JD02_05.TaskA;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Asus on 05.10.2016.
 */
public class Properties {
    private static Locale locale=Locale.ENGLISH;
    private static ResourceBundle resourceBundle=setLocale(locale);


    public static ResourceBundle setLocale(Locale locale) {
      Properties.locale=locale;
        resourceBundle=ResourceBundle.getBundle("by.it.opiga.JD02_05.TaskA.words",locale);
        return  resourceBundle;

    }
    public static String getString(String key)
    {
        return resourceBundle.getString(key);
    }

}
