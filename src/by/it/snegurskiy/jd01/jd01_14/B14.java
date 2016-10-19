package by.it.snegurskiy.jd01.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by snegurskiy.nn on 21.09.2016.
 */
public class B14 {
    public static void B () {
        String src=System.getProperty("user.dir")+"/src/by/it/snegurskiy/";
        String filename = src+"jd01_14/B";
        File f=new File(filename);


        try (BufferedWriter text=new BufferedWriter(new FileWriter(f))){
            String s= "Ugh. First day of New Year has been day of horror. Cannot quite believe I am once again starting the year in " +
                    "a single bed in my parents' house. It is too humiliating at my age. I wonder if they'll smell it if I have a " +
                    "fag out of the window. Having skulked at home all day, hoping hangover would clear, I eventually gave up and set " +
                    "off for the Turkey Curry Buffet far too late. When I got to the Alconburys' and rang their entire-tune-of-town-hallclock-style " +
                    "doorbell I was still in a strange world of my own – nauseous, vile-headed, acidic. I was also suffering from road-rage residue after " +
                    "inadvertently getting on to the M6 instead of the M1 and having to drive halfway to Birmingham before " +
                    "I could find anywhere to turn round. I was so furious I kept jamming my foot down to the floor on the accelerator " +
                    "pedal to give vent to my feelings, which is very dangerous. I watched resignedly as Una Alconbury's form – intriguingly " +
                    "deformed through the ripply glass door bore down on me in a fuchsia two-piece.";
            text.write(s);
//            System.out.println(s);

        } catch (IOException e) {System.out.println(e);}


        try (BufferedReader text=new BufferedReader(new FileReader(f))){
            String s= text.readLine();
            StringBuilder tmp=new StringBuilder(s);
            Pattern p=Pattern.compile("[a-zA-z]+");
            int col=0;
            Pattern p2=Pattern.compile("[.,!?]+");
            int col2=0;
            Matcher m=p.matcher(tmp);
            while (m.find()){
                col++;
            }
            Matcher m2=p2.matcher(tmp);
            while (m2.find()){
                col2++;
            }
            System.out.println("количество слов = "+col);
            System.out.println("количество знаков препинания = "+col2);
        } catch (IOException e) {
            System.out.println(e);}
    }
}
