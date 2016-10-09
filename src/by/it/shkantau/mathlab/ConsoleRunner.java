package by.it.shkantau.mathlab;


import by.it.shkantau.mathlab.calc.Expression;
import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.parser.Parser;
import by.it.shkantau.mathlab.util.parser.RegexPattrn;
import by.it.shkantau.mathlab.util.printer.ConsolePrinter;
import by.it.shkantau.mathlab.util.printer.PrinterScanner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ConsoleRunner {

    private static  Map<String, Var> mapVariables = new HashMap<>();

    public static void main (String [] args) /*throws MathLabException*/ {

        PrinterScanner printerScanner = new ConsolePrinter(System.in);
        String readString;

        String test1 = "А = 2+ 3*(-5.3)/4.5 -5";


        printerScanner.print("*********** Welcome to simple console MathLab v.0.4 ************");


        test1 = test1.replaceAll("\\s" , "");
        Expression expression = new Expression(test1);
        try {
            expression.parse();
            expression.calc();
            mapVariables.put(expression.getResultName(), expression.getResult());
        } catch (MathLabException e) {
            e.printStackTrace();
        }
        printVar(mapVariables);

//        while(true){
//            readString = printerScanner.read();
//            if(readString.equals("\\q")){
//                printVar(mapVariables);
//                break;
//            }else {
//
//                Expression expression = new Expression(readString);
//                try {
//                    expression.parse();
//                    expression.calc();
//                    printerScanner.print(expression.getResultName()+"="+ expression.getResult().toString());
//                } catch (MathLabException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    private static void printVar(Map<String, Var> map){
        for (Map.Entry<String, Var> stringVarEntry : map.entrySet()) {
            System.out.println(stringVarEntry);
        }
    }
}
