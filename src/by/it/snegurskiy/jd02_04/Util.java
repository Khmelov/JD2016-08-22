package by.it.snegurskiy.jd02_04;

import java.util.Scanner;

/**
 * Created by snegurskiy.nn on 05.10.2016.
 */
public class Util {

    static public String getLineConsole (){
        Scanner scanner=new Scanner(System.in);
        System.out.println("type the text");
        String line=scanner.nextLine();
        return line;
    }
}
