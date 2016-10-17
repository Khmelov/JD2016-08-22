package by.it.shkantau.mathlab.util;

import by.it.shkantau.mathlab.calc.Operand.VarF;
import by.it.shkantau.mathlab.calc.Operand.VarM;
import by.it.shkantau.mathlab.calc.Operand.VarV;

 class RegexPattrn {
//    static public final String regexVarF ="((-?)([0-9.])+)";
//    static public final String regexVarV ="\\{((-?([0-9.])+),?)+}";
//    static public final String regexVarM ="\\{((\\{((-?([0-9.])+),?)+}),?)+}";

    static  final String regexAny ="("+ VarM.regexVarM +")|("+ VarV.regexVarV +")|("+ VarF.regexVarF +")";
    private static  final String regexOperators ="[-+*/]";
    public static  final String regexFullExpr = "(" + regexAny + ")" + "((" + regexOperators  + ")"+ "(" + regexAny + "))+";
}
