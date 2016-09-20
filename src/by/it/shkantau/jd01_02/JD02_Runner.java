package by.it.shkantau.jd01_02;

import by.it.aborisenok.JD01_03.InOut;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 14.09.2016.
 */
public class JD02_Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("*********** Welcome HomeWork JD01_02 ************");
        System.out.println("To exit the app type: \\q");

        while(true){
            System.out.print("Type the numbers via white spaces: ");
            ArrayList <String> wordsScratch;

            String str = sc.nextLine().replaceAll("\\s+","");
            if(str.equals("\\q")){
                break;
            }else {


            }
        }
    }

}
