package by.it.aborisenok.matLab.System;

/**
 * Created by aborisenok on 04.10.2016.
 */
public class Patterns {
    //регулярки

    static public String exVal="-?[0-9.]+"; //числа
    static String exVec = "(\\[.+])|(\\{.+})";           //вектора
    static String exMat = "\\{\\{.+}}|\\[\\[.+]]";       //матрицы
    static String exOperation = "[-+*/=]";     //операция
    static String stringVariable = "[a-zA-Z]+";  // буквенная переменная
    static String expInBrackets = "\\([0-9a-zA-Z.,\\{\\}\\[\\]*\\/+\\-]+\\)";


}
