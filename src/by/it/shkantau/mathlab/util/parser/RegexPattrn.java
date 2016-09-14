package by.it.shkantau.mathlab.util.parser;

/**
 * Created by Aliaksei on 13.09.2016.
 */
public class RegexPattrn {
    static public final String regexVarF ="((-?)([0-9.])+)";
    static public final String regexVarV ="\\{((-?([0-9.])+),?)+}";
    static public final String regexVarM ="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    static public final String regexAny ="("+ regexVarM +")|("+ regexVarV +")|("+ regexVarF +")";
    static public final String regexOperators ="[-+*/]";
    static public final String regexFullExpr = "(" + regexAny + ")" + "(" + regexOperators  + ")"+ "(" + regexAny + ")";
}
