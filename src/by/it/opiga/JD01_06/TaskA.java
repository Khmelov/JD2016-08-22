package by.it.opiga.JD01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 02.09.2016.
 */
public class TaskA {
    static String z1(String txt)
    {
        StringBuilder tmp=new StringBuilder(txt);
        Pattern p=Pattern.compile("[а-яA-Z]{5,}");
        Matcher m=p.matcher(tmp);
        while (m.find())
        {
            System.out.println(m.start()+" "+m.group()+",");
            tmp.setCharAt(m.start()+4,'#');
            if(m.group().length()>6)
                tmp.setCharAt(m.start()+6,'#');
        }
        return tmp.toString();
    }

}
