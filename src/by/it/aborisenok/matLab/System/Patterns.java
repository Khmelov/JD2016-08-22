package by.it.aborisenok.matLab.System;

/**
 * Created by aborisenok on 04.10.2016.
 */
public class Patterns {
    //регулярки

    static public String exVal="-?[0-9.]+"; //числа
    static public String exVec = "(\\[.+])|(\\{.+})";           //вектора
    static public String exMat = "\\{\\{.+}}|\\[\\[.+]]";       //матрицы
    static public String exOperation = "[-+*/=]";     //операция
    static public String stringVariable = "[a-zA-Z]+";  // буквенная переменная
    static public String expInBrackets = "\\([0-9a-zA-Z.,\\{\\}\\[\\]*\\/+\\-]+\\)";


}
