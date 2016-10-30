package by.it.filimonchik.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Raman.Filimonchyk on 31/10/2016.
 */
public class Task_B {
    public static void task_B() {
        HashMap<String, Integer> hm = new HashMap<>();
        Pattern p = Pattern.compile( "[a-zA-Z]+" );
        Matcher m = p.matcher( Text.threelittlepigs );
        while (m.find()) {
            String word = m.group();
            if (hm.containsKey( word )) {
                int count = hm.get( word ) + 1;
                hm.remove( word );
                hm.put( word, count );
            } else {
                hm.put( word, 1 );
            }
        }
        printMap( hm );
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.print( pair.getKey() + " = "+ pair.getValue() + " " );
        }
    }
}
















//        while (m.find()) {
//            String s = m.group();
//            if (hm.get(s) == null) {
//                hm.put(s, 1);
//            } else {
//                Integer count = hm.get(s);
//                hm.put(s, ++count);
//            }
//        }
//        System.out.print(s);
//
//    }
//}
