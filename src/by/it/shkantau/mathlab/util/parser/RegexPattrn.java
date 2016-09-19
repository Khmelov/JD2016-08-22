package by.it.shkantau.mathlab.util.parser;

import by.it.shkantau.mathlab.core.Operand.VarF;
import by.it.shkantau.mathlab.core.Operand.VarM;
import by.it.shkantau.mathlab.core.Operand.VarV;

/**
 * Created by Aliaksei on 13.09.2016.
 */
public class RegexPattrn {
//    static public final String regexVarF ="((-?)([0-9.])+)";
//    static public final String regexVarV ="\\{((-?([0-9.])+),?)+}";
//    static public final String regexVarM ="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    static public final String regexAny ="("+ VarM.regexVarM +")|("+ VarV.regexVarV +")|("+ VarF.regexVarF +")";
    static public final String regexOperators ="[-+*/]";
    static public final String regexFullExpr = "(" + regexAny + ")" + "((" + regexOperators  + ")"+ "(" + regexAny + "))+";
}
