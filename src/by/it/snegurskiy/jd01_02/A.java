package by.it.snegurskiy.jd01_02;


/**
 * Created by user on 24.08.2016.
 */
public class A {

    public static String maxLength (String arrStr[]){
        int max=Integer.MIN_VALUE;
        String result="";
        for (String s:arrStr){
            if (s.length()> max){
                result=s;
                max=s.length();
                            }
        }
        return result + " length " + result.length();
    }

    public static String minLength (String arrStr[]){
        int min=Integer.MAX_VALUE;
        String result="";
        for (String s:arrStr){
            if (s.length()< min){
                result=s;
                min=s.length();
            }
        }
        return result + " length " + result.length();
    }

    public static int mean (int Array []){

        int result=0;
    for (int i:Array) result+=i;
        result=result/Array.length;
        return result;
    }

    public static boolean uniqueDigits (Integer value){
        char ch[]=value.toString().toCharArray();
        for (int i = 0; i <ch.length ; i++) {
            for (int j=i+1; j <ch.length ; j++) {
                if (ch[i]==ch[j]) return false;
                            }
        }
        return true;
    }
}







