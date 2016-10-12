package by.it.shkantau.mathlab;


import by.it.shkantau.mathlab.calc.Equation;
import by.it.shkantau.mathlab.calc.Expression;
import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.Logger;
import by.it.shkantau.mathlab.util.printer.ConsolePrinter;
import by.it.shkantau.mathlab.util.printer.PrinterScanner;

import java.util.HashMap;
import java.util.Map;


public class ConsoleRunner {

    private static  Map<String, Var> mapVariables = new HashMap<>();

    public static void main (String [] args) throws MathLabException /*throws MathLabException*/ {

        PrinterScanner printerScanner = new ConsolePrinter(System.in);
        String path = System.getProperty("user.dir") + "/src/by/it/shkantau/mathlab/mathLab.log";
        Logger logger = Logger.getLogger(path);
        String readString;

        String test1 = "А = 2+ 3*(5.3/(4.5 -5)) - 8*(4.34+5)";
        logger.print("Calculate: "+test1);


        printerScanner.print("*********** Welcome to simple console MathLab v.0.4 ************");

//      remove all white spaces
        test1 = test1.replaceAll("\\s" , "");

        Equation equation = new Equation(test1);
        equation.calc();

        mapVariables.put(equation.getResultName(), equation.getResult());

        printVar(mapVariables);
        logger.print(mapVariables.toString());


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
