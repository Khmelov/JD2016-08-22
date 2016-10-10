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
        String innerExpr ;
        while(equation.contains("(")) {
            int index = 0;
            innerExpr = equation;
            if(!Pattern.matches(VarF.regexVarF, equation.substring(equation.indexOf("("),equation.indexOf(")")+1))) {
                index = equation.indexOf("(");
                innerExpr = equation.substring(equation.indexOf("(")+1);
            }
            String innerResultStr = recursiveCalc(innerExpr);
            equation = equation.substring(0, index) + innerResultStr + equation.substring(equation.indexOf(")") + 1);

        }

        String innerExpression = equation.substring(0 , equation.indexOf(")"));
        Expression expression = new Expression(innerExpression);
        expression.parse();
        expression.calc();
        return  expression.getResult().toString();

    }

    public String getResultName() {
        return resultName;
    }

    public Var getResult() {
        return result;
    }
}
