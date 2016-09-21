package by.it.voronovich.MathLab;

import java.util.regex.*;

public class Parser  {

    //RegEx
    //числа
    static public String exScalar = "-?[0-9]+(\\.[0-9]+)?";
    //вектора
    static public String exVector = "[{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}";
    //матрицы
    static public String exMatrix = "[{]{1}([{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}){1}(,[{]{1}(-?[0-9]+(\\.[0-9]+)?){1}(,-?[0-9]+(\\.[0-9]+)?){1,}[}]{1}){1,}[}]{1}";
    //одно из...
    static public String exAny = "("+ exMatrix +")|("+ exVector +")|("+ exScalar +")";
    //операция
    static public String exOper = "((\\s-\\s){1})|((\\s\\+\\s){1})|((\\s\\*\\s){1})|((\\s/\\s){1})|((\\s=\\s){1})";
    //скобки
    static public String exBrackets = "\\(.+\\)";

    //выражение целиком
    static public String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";

    /**
     * Ищет в строке вектор и преобразует в массив double
     * @param line строка
     * @return массив double
     */
    public static double[] findVector(String line) {
        double[] arrayForVector = new double[line.split(",").length];
        Matcher matcherVector = Pattern.compile(exScalar).matcher(line);
        int i = 0;
        while (matcherVector.find()) {
            arrayForVector[i] = Double.parseDouble(matcherVector.group());
            i++;
        }

        return arrayForVector;
    }
}