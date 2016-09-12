package by.it.akhmelev;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        int a=9; int b=13;
        a=-(a-=b)+(b+=a);
        System.out.println(a+" "+b);

        Pattern p = Pattern.compile("(1*)0");
        Matcher m = p.matcher("111110");
        if (m.find()) {
        System.out.println(m.group(1));
        }


        String s1 = "Minsk";
        String s2 = new String("Minsk");
        if(s1.equals(s2.intern())){
            System.out.print("true");
        } else{
            System.out.print("false");
        }
        if(s1 == s2){
            System.out.print("true");
        } else{
            System.out.print("false");
        }
    }
}
