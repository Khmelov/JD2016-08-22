package by.it.shkantau.mathlab;


import by.it.shkantau.mathlab.core.Operand.Var;
import by.it.shkantau.mathlab.util.parser.Parser;
import by.it.shkantau.mathlab.util.parser.RegexPattrn;
import by.it.shkantau.mathlab.util.printer.ConsolePrinter;
import by.it.shkantau.mathlab.util.printer.PrinterScanner;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 11.09.2016.
 */
public class ConsoleRunner {

    public static void main (String [] args) /*throws MathLabException*/ {

        PrinterScanner printerScanner = new ConsolePrinter(System.in);
        Parser parser = new Parser();
        String readString;

        List<Var> operands;
        List<String> operators;
        Var result = null;

        printerScanner.print("*********** Welcome to simple console MathLab v.0.2 ************");

        while(true){
            readString = printerScanner.read();
            if(readString.equals("\\q")){
                break;
            }else {
//                Check typed string for matches full expression
                if(Pattern.matches(RegexPattrn.regexFullExpr , readString)){
                    operands = parser.parseStringToVarList(readString);
                    operators = parser.parseStringToOperatorList(readString);
                    for (int i = 0; i < operators.size() ; i++) {
                                switch (operators.get(i)){
                                case "+": result = operands.get(i).add(operands.get(i+1)); break;
                                case "-": result = operands.get(i).sub(operands.get(i+1)); break;
                                case "*": result = operands.get(i).mul(operands.get(i+1)); break;
                                case "/": result = operands.get(i).div(operands.get(i+1)); break;
                                default: new Error("Wrong operator type");
                            }
                        operands.set(i+1, result);
                    }
                    if(result != null) {
                        printerScanner.print(" = " + result);
                    }

                }else{
                    printerScanner.print("Full typed string is dot't match MathLab requirement, please type string like \n" +
                            " \"{{1,2},{8,3}}-2\" or \"{{1,2},{8,3}}*{1,2}\" or  \"{{1,2},{8,3}}* {{1,2},{8,3}}\" or \"{{1,2},{8,3}}+{{1,2},{8,3}}\"");
                }
            }
        }
    }
}
