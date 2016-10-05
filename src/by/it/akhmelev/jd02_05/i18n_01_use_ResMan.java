package by.it.akhmelev.jd02_05;
        import java.util.Locale;
public class i18n_01_use_ResMan {
    public static void main(String[ ] args) {
        ResMan manager = ResMan.INSTANCE;
        System.out.println(manager.getString("str1"));
        manager.changeResource(new Locale("be","BY"));
        System.out.println(manager.getString("str1"));
    }
}
