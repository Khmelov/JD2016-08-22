package by.it.opiga.JD01_06;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static String z4(String txt) {
        String tmp = new String(txt);
        //StringBuilder tmp=new StringBuilder(txt);
        String[] words = txt.split("[^а-яА-ЯёЁ]+");
        int count = 0;
        Pattern p = Pattern.compile("^[^уеэоаяиюУЕЭОАЯИЮ].");
        //Pattern p=Pattern.compile("\\w{5,5}");

        for (int i = 0; i < words.length; i++) {
            Matcher m = p.matcher(words[i]);
            if (m.find()) {
                if (words[i].length() == 5) {
                    System.out.println(words[i]);
                    //int ind=tmp.indexOf(words[i]);
                    //tmp.delete(ind,ind+5);
                    tmp = tmp.replaceAll(words[i], "");
                }

            }
        }
        return tmp.toString();
    }

    public static void z5(String txt) {
        //String tmp=new String(txt);
        StringBuffer tmp = new StringBuffer(txt.replace("\n", " "));

        System.out.println(tmp);
        String[] words = txt.split("[^:.;][.!?]\\s");
        int[] count = new int[words.length];
        Pattern p = Pattern.compile("[а-яА-ЯёЁ]+");

        for (int i = 0; i < words.length; i++) {
            Matcher m = p.matcher(words[i]);
            while (m.find()) {
                //System.out.println(m.group());
                count[i] = count[i] + 1;
            }

            //System.out.println(count[i]);
            //System.out.println("");
        }
        int col[] = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            col[i] = count[i];
        }
//
        tmp.toString();
        Arrays.sort(count);
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            for (int j = 0; j < col.length; j++) {
                if (count[i] == col[j])
                    System.out.println(words[j]);

            }
            System.out.println("");
        }
    }

    public static void z6(String txt) {
        Pattern p = Pattern.compile("[д]");
        String[] words = txt.split("[^а-яА-ЯёЁ]+");
        int count = 0;
        int[] col = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            Matcher m = p.matcher(words[i]);
            while (m.find()) {
                count++;
            }
            col[i]=count;
            //System.out.println(words[i] + " " + count);
            count = 0;
        }

        System.out.println("после сортировки \n");
        int itemp;
        String stemp;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if(col[i]>col[j])
                {   itemp=col[i];
                    col[i]=col[j];
                    col[j]=itemp;
                    stemp=words[i];
                    words[i]=words[j];
                    words[j]=stemp;
                }
                if(col[i]==col[j])
                {
                    //Метод compareTo(Object obj) возвращает
                    // отрицательное integer, ноль или положительное integer,
                    // когда текущее значение меньше чем, равно, или больше чем полученный объект.
                    if(words[i].compareToIgnoreCase(words[j])>0)
                    {   stemp=words[i];
                        words[i]=words[j];
                        words[j]=stemp;
                    }
                }
            }
        }
        for (int i = 0; i <words.length ; i++) {
            System.out.println(words[i] + " " + count);
        }

    }
}
