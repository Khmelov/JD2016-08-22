package by.it.filimonchik.jd01_06;

/**
 * Created by Raman.Filimonchyk on 08.09.2016.
 */
public class TaskA2 {
    public static class A2 {
        public static void main(String[ ] args) {
            String text=Data.luk;
            String[] mastext= text.split("[^а-яА-ЯёЁ]+");

            for (int i = 0; i < mastext.length; i++) {
                if (mastext[i].length()>0)
                {
                    int count=1;
                    for (int j = i+1; j < mastext.length; j++) {
                        if (mastext[i].equals(mastext[j]))
                        {
                            count++;
                            mastext[j]="";
                        }
                    }
                    System.out.println("Число повторов слова \""+mastext[i]+"\" составляет "+count);
                }
            }

        }
    }
}
