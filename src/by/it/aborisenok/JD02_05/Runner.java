package by.it.aborisenok.JD02_05;


import java.util.Locale;

/**
 * Created by aborisenok on 10.10.2016.
 */
public class Runner {
    public static void main(String[] args) {
        boolean isWork = true;
        while (isWork){
            Properties.setLocale(Locale.getDefault());
            System.out.println(Properties.getString("set.Language") + " ru be en : ");
            String language = Utils.readLanguage();
            if (!language.equals("exit")){
                Utils.printInformation(language);
            } else {
                isWork = false;
            }
        }
    }
}
