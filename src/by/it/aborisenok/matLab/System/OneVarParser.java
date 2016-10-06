package by.it.aborisenok.matLab.System;

import by.it.aborisenok.matLab.Vars.*;

/**
 * Created by aborisenok on 06.10.2016.
 */
public class OneVarParser {
    public static Var parseOneVar(String strVar) { //находит одну переменную
        if (strVar.matches(Patterns.exMat)) return new VarM(strVar);
        else if (strVar.matches(Patterns.exVec)){
            return new VarV(strVar);
        }
        else if (strVar.matches(Patterns.exVal)) return new VarF(strVar);
        else if (strVar.matches(Patterns.stringVariable)) return HashMapper.getVeriable(strVar);
        else   return null;
    }
}
