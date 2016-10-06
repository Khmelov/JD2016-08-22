package by.it.shkantau.mathlab.util.parser;

import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.Operand.VarF;
import by.it.shkantau.mathlab.calc.Operand.VarM;
import by.it.shkantau.mathlab.calc.Operand.VarV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    /**
     *
     * @param parsedStr  input string which parsed to List <String>
     * @param varPattern regular expression
     * @return List of strings which matches Matcher from varPattern
     */
    public static List <String> parseToVarString(String parsedStr, Pattern varPattern){
        List<String> varString = new ArrayList<>();
        Matcher matcherStr = varPattern.matcher(parsedStr);
        while (matcherStr.find()) {
            varString.add(matcherStr.group());
        }
        return varString;
    }

    public static double [] getDoublesArrayFromStr(String str){
        List<String> listOfString = Parser.parseToVarString(str, Pattern.compile(VarF.regexVarF));
        double[] doubles = new double[listOfString.size()];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Double.parseDouble(listOfString.get(i));
        }
        return  doubles;
    }


    public List <Var>  parseStringToVarList(String str) /*throws MathLabException*/ {
        List <Var> varList = new ArrayList<>();
//      parse to any operand string
        List <String> anyOperands = parseToVarString(str, Pattern.compile(RegexPattrn.regexAny));
        for (String operandStr: anyOperands) {
            if(Pattern.matches(VarF.regexVarF, operandStr)){
                varList.add(new VarF(operandStr));
            }else if (Pattern.matches(VarV.regexVarV, operandStr)){
                varList.add(new VarV(operandStr));
            }else if (Pattern.matches(VarM.regexVarM,operandStr)){
                varList.add(new VarM(operandStr));
            }
        }
        return varList;
    }

    public List <String > parseStringToOperatorList(String str){
        String [] operatorString  = str.split(RegexPattrn.regexAny);
        List <String> operatorList = new ArrayList<>( Arrays.asList(operatorString));
        operatorList.removeAll(Arrays.asList("", null));
        return operatorList;
    }

}
