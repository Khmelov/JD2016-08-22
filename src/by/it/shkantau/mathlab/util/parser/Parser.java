package by.it.shkantau.mathlab.util.parser;

import by.it.shkantau.mathlab.core.Var;
import by.it.shkantau.mathlab.core.VarV;
import by.it.shkantau.mathlab.core.exceptions.MathLabExcepion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 11.09.2016.
 */

public class Parser {

    static public final String regexVarF ="((-?)([0-9.])+)";
    static public final String regexVarV ="\\{((-?([0-9.])+),?)+}";
    static public final String regexVarM ="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    static public final String regexAny ="("+ regexVarM +")|("+ regexVarV +")|("+ regexVarF +")";
    static public final String regexOperators ="[-+*/]";
    static public final String regexFullExpr = "(" + regexAny + ")" + "(" + regexOperators  + ")"+ "(" + regexAny + ")";


    private static Scanner scanner = new Scanner(System.in);

    /**
     *
     * @return String typed form console and cleared from white space
     */
    public static String getLine() {
        System.out.print("Type the expression: ");
        return scanner.nextLine().replaceAll("\\s+","");
    }

    public static boolean checkStringPattern(String patternStr, String str){
        Pattern p = Pattern.compile(patternStr);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public List <Var>  parseStringToVarList(String str) throws MathLabExcepion {
        List <Var> varList = new ArrayList<>(2);
        Pattern patternAnyOperand, patternMatrixOperand, patternVectorOperand, patternFloatOperand;
        Matcher matcherFullStr, matcherMatrix, matcherVector, matcherFloat;
// try to find Matrix
        patternAnyOperand =  Pattern.compile(regexAny);
        patternMatrixOperand = Pattern.compile(regexVarM);
        patternVectorOperand = Pattern.compile(regexVarV);
        patternFloatOperand = Pattern.compile(regexVarF);

        matcherFullStr = patternAnyOperand.matcher(str);
        while (matcherFullStr.find()){
            System.out.println("Operand = " + matcherFullStr.group());
            matcherMatrix = patternMatrixOperand.matcher(matcherFullStr.group());
            while (matcherMatrix.find()) {

            }


            varList.add(parseVectorStringToVarV(matcherFullStr.group()));
        }
        return varList;
    }




    private VarV parseVectorStringToVarV (String vectorString) throws MathLabExcepion {
        VarV vector;
        if(checkStringPattern(regexVarV, vectorString)){
            List <Double> listOfDoubles = new ArrayList<>();
            Pattern patternOperand =  Pattern.compile(regexVarF);
            Matcher matcher = patternOperand.matcher(vectorString);
            while (matcher.find()){
                System.out.println(matcher.group());
                listOfDoubles.add(new Double(Double.parseDouble(matcher.group())));
            }
            double [] doubles = new double[listOfDoubles.size()];
            for (int i = 0; i < listOfDoubles.size(); i++) {
                doubles[i] = listOfDoubles.get(i);
            }
            vector = new VarV(doubles);
        }else {
            throw new MathLabExcepion("Wrong vector string format (" + vectorString + ")", MathLabExcepion.WRONG_FORMAT_STRING);
        }
        return vector;
    }


}
