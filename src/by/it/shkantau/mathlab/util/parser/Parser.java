package by.it.shkantau.mathlab.util.parser;

import by.it.shkantau.mathlab.core.Var;
import by.it.shkantau.mathlab.core.VarF;
import by.it.shkantau.mathlab.core.VarM;
import by.it.shkantau.mathlab.core.VarV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksei on 11.09.2016.
 */

public class Parser {

    private static Scanner scanner = new Scanner(System.in);

    /**
     *
     * @return String typed form console and cleared from white space
     */
    public static String getLine() {
        System.out.print("Type the expression: ");
        return scanner.nextLine().replaceAll("\\s+","");
    }

    private List <String> parseToVarString(String parsedStr, Pattern varPattern){
        List<String> varString = new ArrayList<>();
        Matcher matcherStr = varPattern.matcher(parsedStr);
        while (matcherStr.find()) {
//            System.out.println(matcherStr.group());
            varString.add(matcherStr.group());
        }
        return varString;
    }

    public List <Var>  parseStringToVarList(String str) /*throws MathLabException*/ {
        List <Var> varList = new ArrayList<>();
//      parse to any operand string
        List <String> anyOperands = parseToVarString(str, Pattern.compile(RegexPattrn.regexAny));
        for (String operandStr: anyOperands) {
            if(Pattern.matches(RegexPattrn.regexVarF, operandStr)){
                varList.add(new VarF(Double.parseDouble(operandStr)));
            }else if (Pattern.matches(RegexPattrn.regexVarV, operandStr)){
                varList.add(new VarV(parseVectorStrToArrayOfDoubles(operandStr)));
            }else if (Pattern.matches(RegexPattrn.regexVarM,operandStr)){
                varList.add(new VarM(parseMatrixStrToMatrixOfDouble(operandStr)));
            }
        }
        return varList;
    }

    public List <String > parseStringToOperatorList(String str){
        String [] opetatorString  = str.split(RegexPattrn.regexAny);
        List <String> operatorList = new ArrayList<>( Arrays.asList(opetatorString));
        operatorList.removeAll(Arrays.asList("", null));
        return operatorList;
    }

    private double [][] parseMatrixStrToMatrixOfDouble(String  matrixString){
        List <String> vectorStringList =  parseToVarString(matrixString, Pattern.compile(RegexPattrn.regexVarV));
        double [][] matrix = new double[0][];
        for (String operandV: vectorStringList) {
            matrix = addVectorToMatrix(matrix, parseVectorStrToArrayOfDoubles(operandV));
        }
        return matrix;
    }

    private double [][] addVectorToMatrix(double [][] matrix, double [] vector){
        double[][] newArray = Arrays.copyOf(matrix, matrix.length+1);
        newArray[newArray.length-1] = vector;
        return newArray;
    }

    private double [] parseVectorStrToArrayOfDoubles(String vectorString) /*throws MathLabException*/ {
//        if(checkStringPattern(regexVarV, vectorString)){
        List <Double> listOfDoubles = new ArrayList<>();
        Pattern patternOperand =  Pattern.compile(RegexPattrn.regexVarF);
        Matcher matcher = patternOperand.matcher(vectorString);
        while (matcher.find()){
//            System.out.println(matcher.group());
            listOfDoubles.add(new Double(Double.parseDouble(matcher.group())));
        }
        double [] doubles = new double[listOfDoubles.size()];
        for (int i = 0; i < listOfDoubles.size(); i++) {
            doubles[i] = listOfDoubles.get(i);
        }
//        }else {
//            throw new MathLabException("Wrong vector string format (" + vectorString + ")", MathLabException.WRONG_FORMAT_STRING);
//        }
        return doubles;
    }


}
