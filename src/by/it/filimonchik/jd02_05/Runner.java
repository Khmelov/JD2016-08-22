package by.it.filimonchik.jd02_05;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Raman.Filimonchyk on 05/10/2016.
 */
public class Runner implements IKeys {

    static String getOneConsole() {
        return (new Scanner( System.in )).nextLine();
    }

    static void hello() {
        System.out.println( Properties.getString( HELLO ) );
        System.out.println( Properties.getString( HOWDOYOUDO ) );
        System.out.println( Properties.getString( USER ) + "\n" );
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            Properties.setLocale( new Locale( args[0], args[1] ) );
            hello();
            DateFormat df = DateFormat.getDateInstance( DateFormat.LONG, Properties.getLocale() );
            Date d = new Date( System.currentTimeMillis() );
            System.out.print( d + "\n" );
            System.out.println( Properties.getString( LANGUAGE ) );
            String language;

            while (!(language = getOneConsole()).isEmpty()) {
                Locale locale = Properties.getLocale();
                if (language.equals( "be" )) {
                    locale = new Locale( "be", "BY" );
                } else if (language.equals( "ru" )) {
                    locale = new Locale( "ru", "RU" );
                } else if (language.equals("en")) {
                    locale = new Locale("en","EN");
                }
                Properties.setLocale( locale );
                hello();
            }


        }
    }
}














//            while (!(language = getOneConsole()).isEmpty()) {
//                Locale locale;
//                if (language.equals("be")) {
//                    locale = new Locale("be", "BY");
//                } else if (language.equals("ru")) {
//                    locale = new Locale("ru", "RU");
//                } else if (language.equals("en")) {
//                    locale = new Locale("en");
//
//                }
//
//            }
//        }
//    }
//}


//        System.out.println(Properties.getString(HELLO));
//        System.out.println(Properties.getString(HOWDOYOUDO));
//        System.out.println(Properties.getString("user")+"\n");
//
//        Properties = new Properties.setLocale((new Locale("ru", "RU"));
//        System.out.println(Properties.getString("hello"));
//        System.out.println(Properties.getString("howdoyoudo"));
//        System.out.println(Properties.getString("user")+"\n");
//
//        ResourceBundle resourceBundle1 = Properties.setLocale(new Locale("by", "BY");
//        System.out.println(Properties.getString("hello"));
//        System.out.println(Properties.getString("howdoyoudo"));
//        System.out.println(Properties.getString("user")+"\n");

//    }
//}
