package by.it.voronovich.JD02_04.Operation;

import by.it.voronovich.JD02_04.Var.Variable;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.voronovich.JD02_04.Parser.exName;
import static by.it.voronovich.JD02_04.Parser.parsEq;

public class KeyMapper {

    private KeyMapper() {
    }

    private static Map<String, Variable> variable = new HashMap<>();

    public static Map<String, Variable> getVariable() {
        return KeyMapper.variable;
    }

    /**
     * Проверка наличия в MAP'e имени переменной
     *
     * @param str строка
     * @return true/false
     */
    public static boolean checkingName(String str) {
        Map<String, Variable> map = KeyMapper.getVariable();
        if (str.contains("=")) {
            String name = parsEq(str).get(0);
            if (map.containsKey(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверка переменных записанных в MAP'e
     *
     * @param str Строка ввода
     * @return true/false
     */
    public static boolean checkingVar(String str) {
        Map<String, Variable> map = KeyMapper.getVariable();
        if (str.contains("=")) {
            str = str.substring(str.indexOf("="));
        }
        Matcher m = Pattern.compile(exName).matcher(str);
        while (m.find()) {
            String s = m.group();
            if (!map.containsKey(s)) {
                return false;
            }
        }
        return true;
    }
}