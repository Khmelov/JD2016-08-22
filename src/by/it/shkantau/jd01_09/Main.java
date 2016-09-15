package by.it.shkantau.jd01_09;


import by.it.shkantau.jd01_09.util.parser.Parser;
import by.it.shkantau.jd01_09.util.printer.ConsolePrinter;
import by.it.shkantau.jd01_09.util.printer.Printer;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class Main {
    public static void main (String [] args){

        Printer printer = new ConsolePrinter();
        Parser parser = new Parser();



        printer.print("Welcome to simple MathLab");

//        double[][] matrix = {
//                {2, 5, 4, 1},
//                {1, 3, 2, 1},
//                {2, 10, 9, 7},
//                {3, 8, 9, 2}
//        };
//        VarM varM = new VarM(matrix);
//        System.print.println(varM.toString());
//        System.print.println(varM.add(new VarF(100)).toString());

        String consoleString = Parser.getLine();
        consoleString.replaceAll(" ", "");
        String regex = Parser.FULL_EXPRESSION;



        boolean bul = Parser.checkStringPattern(regex , consoleString);//
//        printer.print("consoleString = " + consoleString +" , regex="+regex + " , match = " + bul);
        printer.print("String match full regex = " + bul);

    }
}
