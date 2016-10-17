package by.it.shkantau.mathlab.calc;

import by.it.shkantau.mathlab.ConsoleRunner;
import by.it.shkantau.mathlab.calc.Operand.Var;
import by.it.shkantau.mathlab.calc.Operand.VarF;
import by.it.shkantau.mathlab.calc.exceptions.MathLabException;
import by.it.shkantau.mathlab.util.Parser;

import java.util.regex.Pattern;

public class Equation {
    private String equationStr;
    private String resultName;
    private Var result;


    public Equation(String string) throws MathLabException {
        String[] strings = Parser.splitExpressionAndName(string);
        this.resultName = strings[0];
        this.equationStr = ConsoleRunner.replaceAllLiteralVariables(strings[1]);
    }

    public void calc() throws MathLabException {
        recursiveCalc(equationStr);
    }

    private String recursiveCalc(String equation) throws MathLabException {
        String innerExpr;
        while((innerExpr = replaceParenthesis(equation))!= null){
            equation = equation.replace("("+innerExpr+")",recursiveCalc(innerExpr));
        }
        return calcExpressionWithoutParenthesis(equation);
    }

    private String calcExpressionWithoutParenthesis(String exprStr) throws MathLabException {
        Expression expression = new Expression(exprStr);
        result =  expression.getResult();
        return expression.getResult().toString();
    }

    private String replaceParenthesis(String expr) throws MathLabException {
        int startIndex, endIndex, counter;
        String innerParenthesisStr;
        while(true) {
            startIndex = -1; endIndex = -1; counter = 0;
            for (int i = 0; i < expr.length(); i++) {
                if (expr.charAt(i) == '(') {
                    if (startIndex == -1) {
                        startIndex = i + 1;
                    }
                    counter++;
                }
                if (expr.charAt(i) == ')') {
                    if (counter == 1) {
                        endIndex = i;
                        break;
                    }
                    counter--;
                }
            }
            if ((startIndex == -1) && (endIndex == -1)) {
                return null;
            }
            innerParenthesisStr = expr.substring(startIndex - 1, endIndex + 1);
            if (isNegativeVar(innerParenthesisStr) || Parser.isVar(innerParenthesisStr)) {
                expr = expr.replace(innerParenthesisStr, "");
            } else break;
        }
        return (expr.substring(startIndex, endIndex));
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
