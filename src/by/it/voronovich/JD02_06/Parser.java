package by.it.voronovich.JD02_06;

import by.it.voronovich.JD02_06.Operation.KeyMapper;
import by.it.voronovich.JD02_06.Var.Variable;
import by.it.voronovich.JD02_06.Var.VariableFloat;
import by.it.voronovich.JD02_06.Var.VariableMatrix;
import by.it.voronovich.JD02_06.Var.VariableVector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс содержит регулярные выражения и отвечает за
 * раскладку введенной строки согласно заданным выражениям и
 * корректной расстановке скобок
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Parser {

    //регулярные выражения
    public static String exEq = "\\s?=\\s?";
    public static String exName = "[a-zA-Z]";
    public static String exFloat = "-?[0-9]+(\\.[0-9]+)?";
    public static String exVector = "[\\{\\[](-?[0-9\\.,])+[\\}\\]]";
    public static String exMatrix = "[\\{\\[](([\\{\\[](-?[0-9\\.,])+[\\}\\]]),?)+[\\}\\]]";
    public static String exOperation = "\\s[\\+\\-/\\*]\\s";
    public static String exStr = "(" + exMatrix + ")|(" + exVector + ")|(" + exFloat + ")|(" + exName + ")";
    public static String exMul = "(" + exStr + ")\\s\\*\\s(" + exStr + ")";
    public static String exDiv = "(" + exStr + ")\\s/\\s(" + exStr + ")";
    public static String exBrackets = "\\(\\(*(" + exStr + ")((" + exOperation + ")\\(?(" + exStr + ")\\)?)+\\)";

    /**
     * Чтение строки, создание списка переменных
     *
     * @param str строка
     * @return список
     */
    public static List<Variable> parsVar(String str) {
        List<Variable> vars = new ArrayList<>();
        String[] elemString = new String[2];
        if (str.contains("(") && str.contains(")")) {
            str = str.substring(1, str.length() - 1);
        }
        if (!Pattern.compile(exStr).matcher(str).matches()) {
            elemString = str.split(exOperation);
        } else {
            elemString[0] = str;
            elemString[1] = str;
        }
        Map<String, Variable> map = KeyMapper.getVariable();
        for (int i = 0; i < elemString.length; i++) {
            if (Pattern.compile(exName).matcher(elemString[i]).matches()) {
                elemString[i] = map.get(elemString[i]).toString();
            }
        }
        for (int i = 0; i < elemString.length; i++) {
            if (Pattern.compile(exFloat).matcher(elemString[i]).matches()) {
                vars.add(new VariableFloat(elemString[i]));
            } else if (Pattern.compile(exVector).matcher(elemString[i]).matches()) {
                vars.add(new VariableVector(elemString[i]));
            } else if (Pattern.compile(exMatrix).matcher(elemString[i]).matches()) {
                vars.add(new VariableMatrix(elemString[i]));
            } else vars.add(null);
        }
        return vars;
    }

    /**
     * Операция в выражении
     *
     * @param str строка
     * @return строковое значение операции
     */
    public static String parsOperation(String str) {
        Matcher m = Pattern.compile(exOperation).matcher(str);
        String operation = null;
        while (m.find()) {
            operation = m.group();
        }
        return operation;
    }

    /**
     * Расстановка приоритета операций
     *
     * @param str строка
     * @return приоритетная часть выражения
     */
    public static String priorityOperation(String str) {
        Matcher m = Pattern.compile("(" + exMul + ")|(" + exDiv + ")|(" + exBrackets + ")").matcher(str);
        String priorityEx = null;
        if (m.find()) {
            String find = m.group();
            if (find.charAt(0) == '(') {
                LinkedList<String> list = new LinkedList<>();
                int x = 1;
                list.addFirst(Character.toString(find.charAt(0)));
                while (!list.isEmpty()) {
                    if (find.charAt(x) == '(') {
                        list.addFirst(Character.toString(find.charAt(x)));
                    }
                    if (find.charAt(x) == ')') {
                        list.removeFirst();
                    }
                    x++;
                }
                priorityEx = find.substring(0, x);
            } else {
                priorityEx = find;
            }
        }
        return priorityEx;
    }

    /**
     * Чтение строки по операциям
     *
     * @param str Выражения для парсинга
     * @return список переменных
     */
    public static List<String> parsExp(String str) {
        String[] elemString = str.split(exOperation);
        List<String> exp = new ArrayList<>();
        for (int i = 0; i < elemString.length; i++) {
            exp.add(elemString[i]);
        }
        return exp;
    }

    /**
     * Чтение строки с присваиванием переменной
     *
     * @param str строка
     * @return строка
     */
    public static List<String> parsEq(String str) {
        String[] elemString = str.split(exEq);
        List<String> exp = new ArrayList<>();
        for (int i = 0; i < elemString.length; i++) {
            exp.add(elemString[i]);
        }
        return exp;
    }

    /**
     * Проверка строки ввода на соответствие выражению
     *
     * @param str строка
     * @return true/false
     */
    public static boolean checkingExp(String str) {
        if (!Pattern.compile("(\\w(" + exEq + "))?\\(*(" + exStr + ")" +
                "((" + exOperation + ")\\(*(" + exStr + ")\\)*)*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    /**
     * Метод определяет правильность порядка расстановки скобок в строке
     * @param str строка
     * @return true/false
     */
    public static boolean bracketsArrangement(String str) {

        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                list.addFirst(Character.toString(str.charAt(i)));
            }
            if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')' && !list.isEmpty()) {
                if (list.getFirst().equals("{") && str.charAt(i) == '}') {
                    list.removeFirst();
                } else if (list.getFirst().equals("(") && str.charAt(i) == ')') {
                    list.removeFirst();
                } else if (list.getFirst().equals("[") && str.charAt(i) == ']') {
                    list.removeFirst();
                } else {
                    return false;
                }
            } else if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')' && list.isEmpty()) {

                return false;
            }
            i++;
        }
        if (!list.isEmpty()) {
            return false;
        }
        return true;
    }
}