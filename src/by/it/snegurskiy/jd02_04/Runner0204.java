package by.it.snegurskiy.jd02_04;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by snegurskiy.nn on 05.10.2016.
 */
public class Runner0204 {
    public static void main(String[] args) {
//        String s=Util.getLineConsole();
        String s="6+6-3-2";
        ArrayList<String> sign=new ArrayList<>();
        ArrayList<Integer> number=new ArrayList<>();
        Pattern p=Pattern.compile("[*/+-]");
        Matcher m=p.matcher(s);
        while (m.find()){
            sign.add(m.group());
        }
        Pattern p1=Pattern.compile("\\d+");
        Matcher m1=p1.matcher(s);
        while (m1.find()){
            number.add(Integer.parseInt(m1.group()));
        }
        int sum= number.get(0)+number.get(1);
        System.out.println(sign.toString());
        System.out.println(number.toString());
        System.out.println(sum);

    }



}
