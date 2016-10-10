package by.it.voronovich.JD02_06.Operation;

import by.it.voronovich.JD02_06.Parser;
import by.it.voronovich.JD02_06.UnsupportedException;
import by.it.voronovich.JD02_06.Var.Variable;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.voronovich.JD02_04.Parser.exOperation;
import static by.it.voronovich.JD02_04.Parser.exStr;

/**
 * Класс выполняет вычисления
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Calculator {

    /**
     * Метод запускает калькулятор
     *
     * @param str строка
     * @return строковое представление результата
     */
    public String calculator(String str) throws UnsupportedException {
        Variable result;
        String name = null;
        if (str.contains("=")) {
            name = Parser.parsEq(str).get(0);
            str = Parser.parsEq(str).get(1);
            if (Pattern.compile(exStr).matcher(str).matches()) {
                result = Parser.parsVar(str).get(0);
            } else {
                result = calculate(str);
            }
        } else {
            result = calculate(str);
        }

        if (name != null && result != null) {
            result.saveVar(name);
            str = name + " = " + result.toString();
        } else if (name == null && result != null) {
            str = result.toString();
        } else {
            str = null;
        }
        return str;
    }

    /**
     * Калькулятор
     *
     * @param str строка
     * @return результат вычислений
     */
    public Variable calculate(String str) throws UnsupportedException {
        Variable result = null;
        String string;
        List<Variable> var;
        String exp = Parser.priorityOperation(str);
        if (exp != null) {
            if (!Pattern.compile("\\(?(" + exStr + ")(" + exOperation + ")(" + exStr + ")\\)?").matcher(exp).matches()) {
                if (exp.contains("(") && exp.contains(")")) {
                    string = exp.substring(1, exp.length() - 1);

                } else {
                    string = exp;
                }
                result = calculate(string);
                str = str.replace(exp, result.toString());
            }
        }
        exp = Parser.priorityOperation(str);
        String operation;
        while (exp != null) {
            if (!Pattern.compile("\\(?(" + exStr + ")(" + exOperation + ")(" + exStr + ")\\)?").matcher(exp).matches()) {
                string = exp.substring(1, exp.length() - 1);
                result = calculate(string);
                str = str.replace(exp, result.toString());
                exp = Parser.priorityOperation(str);
                continue;
            }
            var = Parser.parsVar(exp);
            operation = Parser.parsOperation(exp);
            result = chooseOperation(var.get(0), var.get(1), operation);
            String sub = Parser.parsExp(exp).get(0) + operation + Parser.parsExp(exp).get(1);
            if (result != null) {
                str = str.replace(sub, result.toString());
            } else {
                return null;
            }
            exp = Parser.priorityOperation(str);
        }
        Matcher m = Pattern.compile("\\(?(" + exStr + ")(" + exOperation + ")(" + exStr + ")\\)?").matcher(str);
        while (m.find()) {
            String s = m.group();
            var = Parser.parsVar(s);
            operation = Parser.parsOperation(s);
            result = chooseOperation(var.get(0), var.get(1), operation);
            if (result != null) {
                String sub = Parser.parsExp(s).get(0) + operation + Parser.parsExp(s).get(1);
                String l = str.replace(sub, result.toString());
                str = l;
                m.reset(l);
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * Выбор действия
     *
     * @param var1 переменная
     * @param var2 переменная
     * @param operation строковое представление операции
     * @return результат
     */
    private Variable chooseOperation(Variable var1, Variable var2, String operation) throws UnsupportedException {
        Addition add = new Addition();
        Substruction sub = new Substruction();
        Multiplication mult= new Multiplication();
        Division div = new Division();
        Variable result = null;
        switch (operation) {
            case " + ": {
                result = add.addition(var1, var2);
                break;
            }
            case " - ": {
                result = sub.substraction(var1, var2);
                break;
            }
            case " * ": {
                result = mult.multiplication(var1, var2);
                break;
            }
            case " / ": {
                result = div.division(var1, var2);
                break;
            }
        }
        return result;
    }
}