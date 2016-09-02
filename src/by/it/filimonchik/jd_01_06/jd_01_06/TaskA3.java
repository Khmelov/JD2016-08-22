package by.it.filimonchik.jd_01_06.jd_01_06;

/**
 * Created by user on 02.09.2016.
 */
public class TaskA3 {
    static boolean Glasnaya(String word){
        String oae ="яыуаиеоюэё";
        oae=oae+oae.toUpperCase();
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return (oae.indexOf(first)>0)&& oae.indexOf(last)>0;
    }
    public static void main (String [] args){

    }
}
