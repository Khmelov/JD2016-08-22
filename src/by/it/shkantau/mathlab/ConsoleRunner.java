package by.it.shkantau.mathlab;


import by.it.shkantau.mathlab.calc.Equation;
import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.Logger;
import by.it.shkantau.mathlab.util.ResultLoaderSaver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {
    private static String porjectDir = System.getProperty("user.dir") + "/src/by/it/shkantau/mathlab/";
    private static  Map<String, Var> mapVariables = new HashMap<>();
    private static String resultFileName = porjectDir + "variableStorage.dat";

    public static void main (String [] args) /*throws MathLabException*/ {

        Scanner scanner = new Scanner(System.in);
        String path = porjectDir +"mathLab.log";
        Logger logger = Logger.getLogger(path);
        String readString;

//        String test1 = "A = 2+ 3*(5.3/(4.5 -5)) - 8*(4.34+5)";
//        String test2 = "B = 2+ 3*({3,5,6.4})";

        try {
            mapVariables = ResultLoaderSaver.load(resultFileName);
        } catch (IOException | MathLabException e) {
            logger.print(e.toString());
            e.printStackTrace();
        }

        System.out.println("*********** Welcome to simple console MathLab v.0.9 ************");
        System.out.println("\\q - Exit MathLab, \\v - print local variables");
        System.out.println("Type equation:");

        label:
        while (true) {
            readString = scanner.nextLine();
            switch (readString) {
                case "\\q":
                    try {
                        ResultLoaderSaver.save(mapVariables, resultFileName);
                    } catch (IOException e) {
                        logger.print("Calculate: " + readString);
                        e.printStackTrace();
                    }

                    break label;
                case "\\v":
                    printVar(mapVariables);
                    break;
                default:
                    if (readString.equals("")) {
                        System.out.println("Wrong equation");
                    } else {
                        //remove all white spaces
                        logger.print("Calculate: " + readString);
                        readString = readString.replaceAll("\\s", "");

                        Equation equation;
                        try {

                            equation = new Equation(readString);
                            equation.calc();
                            System.out.println(equation.getResultName() + " = " + equation.getResult());
                            mapVariables.put(equation.getResultName(), equation.getResult());
                            logger.print(mapVariables.toString());
                        } catch (MathLabException e) {
                            logger.print(e.toString());
//                        e.printStackTrace();
                        }


                    }
                    break;
            }
        }
    }

//    public static Var getVarFromMapVariables(String varName){
//        return mapVariables.get(varName);
//    }

    public static String replaceAllLiteralVariables(String equation){
        for (String key : mapVariables.keySet()) {
            equation = equation.replaceAll(key,mapVariables.get(key).toString());
        }
        return equation;
    }



    private static void printVar(Map<String, Var> map){
        for (Map.Entry<String, Var> stringVarEntry : map.entrySet()) {
            System.out.println(stringVarEntry);
        }
    }
}
