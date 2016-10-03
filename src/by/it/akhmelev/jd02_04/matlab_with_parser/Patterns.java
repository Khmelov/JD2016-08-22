package by.it.akhmelev.jd02_04.matlab_with_parser;

public class Patterns {
    //регулярки

    static public String exVal="-?[0-9.]+"; //числа
    static String exVec="\\{.+}";           //вектора
    static String exMat="\\{\\{.+}}";       //матрицы
    static String exOperation ="[-+*/]";    //операция

    //static String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    //static String exFull= "("+exAny+")"+"(" +exOperation+")"+ "(" +exAny +")"; //выражение целиком

}
