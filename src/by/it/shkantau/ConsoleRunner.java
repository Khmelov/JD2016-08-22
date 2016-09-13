package by.it.shkantau;


import by.it.shkantau.mathlab.core.Var;
import by.it.shkantau.mathlab.util.parser.Parser;
import by.it.shkantau.mathlab.util.printer.ConsolePrinter;
import by.it.shkantau.mathlab.util.printer.Printer;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class ConsoleRunner {
    public static void main (String [] args) /*throws MathLabException*/ {

        Printer printer = new ConsolePrinter();
        Parser parser = new Parser();
        List<Var> operands;
        List<String> operators;
        Var result = null;

        printer.print("*********** Welcome to simple MathLab ************");
        printer.print("To exit the app type: \\q");

        while(true){
            String consoleString = Parser.getLine();
            if(consoleString.equals("\\q")){
                break;
            }else {
                if(Pattern.matches(Parser.regexFullExpr , consoleString)){
                    operands = parser.parseStringToVarList(consoleString);
                    operators = parser.parseStringToOperatorList(consoleString);
                    for (int i = 0; i < operators.size() ; i++) {
                            switch (operators.get(i)){
                                case "+": result = operands.get(i).add(operands.get(i+1)); break;
                                case "-": result = operands.get(i).sub(operands.get(i+1)); break;
                                case "*": result = operands.get(i).mul(operands.get(i+1)); break;
                                case "/": result = operands.get(i).div(operands.get(i+1)); break;
                            }

                    }
                    if(result != null) {
                        printer.print(" = " + result);
                    }

                }else{
                    printer.print("Full typed string is dot't match MathLab requirement, please type string like \n" +
                            " \"{{1,2},{8,3}}-2\" or \"{{1,2},{8,3}}*{1,2}\" or  \"{{1,2},{8,3}}* {{1,2},{8,3}}\" or \"{{1,2},{8,3}}+{{1,2},{8,3}}\"");
                }
            }
        }
    }
}
