package by.it.filimonchik.jd01_02;

/**
 * Created by Raman.Filimonchyk on 05.09.2016.
 */
public class TaskA {
//    поиск максимума
    public static String maxLength(String arrStr[]) {
        int max = Integer.MIN_VALUE;
        String result = "";
        for (String s : arrStr) {
            if (s.length() > max) {
                result = s;
                max = s.length();
            }
        }
        return result;
    }
//    поиск минимума
    public static String minLength(String arrStr[]) {
        int min = Integer.MAX_VALUE;
        String result = "";
        for (String s : arrStr) {
            if (s.length() < min) {
                result = s;
                min = s.length();
            }
        }
        return result;
    }
//     поиск среднего арифметического
   public static double mean(int mas[]) {
            double res = 0;
            for (int i : mas) res = res + i;
            res /=mas.length;
            return res;
        }
    static boolean uniqueDigits(String value){
        char ch[]=value.toString().toCharArray();
        for (int i=0;i<ch.length;i++)
            for (int j=i+1;j<ch.length;j++)
                if (ch[i]==ch[j]) return false;
        return true;
    }


}