package by.it.shkantau;


import by.it.shkantau.mathlab.core.exceptions.MathLabExcepion;
import by.it.shkantau.mathlab.util.parser.Parser;
import by.it.shkantau.mathlab.util.printer.ConsolePrinter;
import by.it.shkantau.mathlab.util.printer.Printer;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class ConsoleRunner {
    public static void main (String [] args) throws MathLabExcepion {

        Printer printer = new ConsolePrinter();
        Parser parser = new Parser();
        boolean matches;

        printer.print("*********** Welcome to simple MathLab ************");
        printer.print("To exit the app type: \\q");

        while(true){
            String consoleString = Parser.getLine();
            if(consoleString.equals("\\q")){
                break;
            }else {
                matches = Parser.checkStringPattern(Parser.regexFullExpr , consoleString);
                if(matches == true){
                    parser.parseStringToVarList(consoleString);
                }else{
                    printer.print("Full typed string is dot't match MathLab requirement, please type string like \n" +
                            " \"{{1,2},{8,3}}-2\" or \"{{1,2},{8,3}}*{1,2}\" or  \"{{1,2},{8,3}}* {{1,2},{8,3}}\" or \"{{1,2},{8,3}}+{{1,2},{8,3}}\"");
                }
            }
        }
    }
}
