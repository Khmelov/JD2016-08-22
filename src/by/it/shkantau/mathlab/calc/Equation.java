package by.it.shkantau.mathlab.calc;

import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.Operand.VarF;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.parser.Parser;

import java.util.regex.Pattern;

public class Equation {
    private String equationStr;
    private String resultName;
    private Var result;

    public Equation(String string) throws MathLabException {
        String[] strings = Parser.splitExpressionAndName(string);
        this.resultName = strings[0];
        this.equationStr = strings[1];
    }

    public void calc() throws MathLabException {
        recursiveCalc(equationStr);
    }


    private String recursiveCalc(String equation) throws MathLabException {

        int level = 0;
        String innerExpr;
        while((innerExpr = replaceParenthesis(equation)) != null){
            if ((innerExpr.indexOf('(') & innerExpr.indexOf(')')) < 0 )
                recursiveCalc(innerExpr);
        }
        return null;

    }

    private boolean isNextNegativeVar(String str){
        return Pattern.matches(VarF.regexVarF, str.substring(str.indexOf("("),str.indexOf(")")+1));
    }

    private String replaceParenthesis(String expr){
        int startIndex = -1, endIndex = -1, counter = 0;
        for (int i = 0; i < expr.length(); i++) {
            if (expr.charAt(i) == '('){
                if (startIndex == -1){
                    startIndex = i+1;
                }
                counter++;
            }
            if(expr.charAt(i) == ')'){
                if (counter == 1){
                    endIndex = i;
                    break;
                }
                counter--;
            }
        }
        return ((startIndex == -1)&&(endIndex == -1)) ? null : expr.substring(startIndex, endIndex);
    }


    public String getResultName() {
        return resultName;
    }

    public Var getResult() {
        return result;
    }
}
