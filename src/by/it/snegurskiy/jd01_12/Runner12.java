package by.it.snegurskiy.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by snegurskiy.nn on 16.09.2016.
 */
public class Runner12 {
    public static void main(String[] args) {


        HashMap<String, Integer> spisok = new HashMap<String, Integer>();
        spisok.put("Ivanov", 0);
        spisok.put("Petrov", 0);
        spisok.put("Sidorov", 0);
        spisok.put("Ivanova", 0);
        spisok.put("Jevnov", 0);
        spisok.put("Kim", 0);
        spisok = A12.supplyAssessment(spisok);// проставил оценки рандом
        ArrayList<Integer> Assessment = new ArrayList<Integer>();
        //System.out.println(spisok);
//        System.out.println("Залание А1");
//        A12.zapolnitspisok(Assessment);
//        System.out.println(Assessment);
//        A12.A11(Assessment);
//        System.out.println(Assessment);
//        System.out.println("Залание А2");
//        ArrayList <Integer> set1 = new ArrayList<Integer>();
//        ArrayList <Integer> set2 = new ArrayList<Integer>();
//        A12.zapolnitspisok(set2);
//        A12.zapolnitspisok(set1);
//        ArrayList UnionArray = MyCollect.getUnion(set1, set2);
//        ArrayList GetCross=MyCollect.getCross(set1,set2);
//        System.out.println(set1);
//        System.out.println(set2);
//        System.out.println(GetCross);
//        System.out.println(UnionArray);
//        System.out.println("Залание А3");
//        ArrayList <Integer> setA3 =new ArrayList<>();
//        A12.zapolnitspisok2(setA3);
//        System.out.println(setA3);
//        Collections.sort(setA3);
//        Collections.reverse(setA3);
//        System.out.println(setA3);

//        System.out.println("Залание B1");
//        String s = "Ugh. First day of New Year has been day of horror. Cannot quite believe I am once again starting the year in " +
//                "a single bed in my parents' house. It is too humiliating at my age. I wonder if they'll smell it if I have a " +
//                "fag out of the window. Having skulked at home all day, hoping hangover would clear, I eventually gave up and set " +
//                "off for the Turkey Curry Buffet far too late. When I got to the Alconburys' and rang their entire-tune-of-town-hallclock-style " +
//                "doorbell I was still in a strange world of my own – nauseous, vile-headed, acidic. I was also suffering from road-rage residue after " +
//                "inadvertently getting on to the M6 instead of the M1 and having to drive halfway to Birmingham before " +
//                "I could find anywhere to turn round. I was so furious I kept jamming my foot down to the floor on the accelerator " +
//                "pedal to give vent to my feelings, which is very dangerous. I watched resignedly as Una Alconbury's form – intriguingly " +
//                "deformed through the ripply glass door bore down on me in a fuchsia two-piece.";
//        ArrayList<String> TextS = B12.textInArray(s);
//        HashMap<String, Integer> TextHM = new HashMap();
//        TextHM=B12.B1(TextS);
//        System.out.println(TextHM);

        System.out.println("Залание B2");
        ArrayList<Integer> circul1=new ArrayList<>();
        for (int i = 1; i <=15 ; i++) {
            circul1.add(i);
        }
        LinkedList<Integer> circul2=new LinkedList<>();
        circul2.addAll(circul1);
        long timeStart= (long) System.currentTimeMillis();
        System.out.println(B12.deletecircul(circul1));
        System.out.println((long) System.currentTimeMillis()-timeStart);
        timeStart= (long) System.currentTimeMillis();
        System.out.println(B12.deletecircul(circul2));
        System.out.println((long) System.currentTimeMillis()-timeStart);
    }
}