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
    private int recurseLevel;

    public Equation(String string) throws MathLabException {
        String[] strings = Parser.splitExpressionAndName(string);
        this.resultName = strings[0];
        this.equationStr = strings[1];
    }

    public void calc() throws MathLabException {
//        while(haveParenthesis(equationStr)) {
            equationStr = recursiveCalc(equationStr);
//        }
    }

    private String recursiveCalc(String equation) throws MathLabException {
        String innerExpr;
        recurseLevel++;
        if(haveParenthesis(equation)){
            innerExpr = replaceParenthesis(equation);
            equation = equation.replace("("+innerExpr+")",recursiveCalc(innerExpr));
        }
        recurseLevel--;
        if (recurseLevel==0){
            result = new Expression(equation).getResult();
        }
        return calcExpressionWithoutParenthesis(equation);
    }

    private String calcExpressionWithoutParenthesis(String exprStr) throws MathLabException {
        Expression expression = new Expression(exprStr);
        return expression.getResult().toString();
    }

    private boolean haveParenthesis(String expr){
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
        return !((startIndex == -1) && (endIndex == -1) || isNegativeVar(expr.substring(startIndex, endIndex)));
    }

    private String replaceParenthesis(String expr) throws MathLabException {
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

//        if((startIndex == -1)&&(endIndex == -1)){
//            expr = calcExpressionWithoutParenthesis(expr);
//        }else{
//            expr = expr.substring(startIndex, endIndex);
//        }
//        return  expr;
        return ((startIndex == -1)&&(endIndex == -1)) ? null : expr.substring(startIndex, endIndex);
    }

    private boolean isNegativeVar(String str){
        return Pattern.matches(VarF.regexVarF, str);
    }

    public String getResultName() {
        return resultName;
    }

    public Var getResult() {
        return result;
    }
}
