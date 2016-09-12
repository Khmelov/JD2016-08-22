package by.it.snegurskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 02.09.2016.
 */
public class A6 {
    public static String a1(String txt){
        StringBuilder tmp=new StringBuilder(txt);
        Pattern p=Pattern.compile("[а-яА-яёЁ]{5,}");
        Matcher m=p.matcher(tmp);
        while (m.find()){
            tmp.setCharAt(m.start()+4,'#');
            if (m.group().length()>6) tmp.setCharAt(m.start()+6,'#');
        }


        return tmp.toString();
    }

    static void a2(String args) {
        String [] words=args.split("[^а-яА-яёЁ]+");
        for (int i = 0; i <words.length-1 ; i++) {
            int cont=1;
            if (words[i]!=""){
            for (int j =i+1; j <words.length; j++) {
                if (words[i].equals(words[j])) {cont++; words[j]="";}}
            System.out.println(words[i]+" "+cont);

        }}}

    public static boolean glasnaya(String word) {
        String glasnie="уеёыиаоэяюУЕЁЫАОЭЯИЮ";
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return  (glasnie.indexOf(first)>=0&&glasnie.indexOf(last)>=0);

    }

    static void a3(String args) {
        String [] words=args.split("[^а-яА-яёЁ]+");
        int cont=0;
        for (int i = 0; i <words.length ; i++) {
            if (glasnaya(words[i])) cont++;}
        System.out.println(cont);

            }








//    public static void a3(String args) {
//
//
//    }
}
