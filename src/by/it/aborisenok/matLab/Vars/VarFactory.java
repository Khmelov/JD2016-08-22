package by.it.aborisenok.matLab.Vars;

import by.it.aborisenok.matLab.Errors.UseOfUnknownVariableException;
import by.it.aborisenok.matLab.System.*;

/**
 * Created by aborisenok on 17.10.2016.
 */
public class VarFactory {
    public static Var getVar(String var){
        if (var.matches(Patterns.exMat)) return new VarM(var);
        else if (var.matches(Patterns.exVec)){
            return new VarV(var);
        }
        else if (var.matches(Patterns.exVal)) return new VarF(var);
        else if (var.matches(Patterns.stringVariable)) return by.it.aborisenok.matLab.System.HashMapper.getVeriable(var);
        else   throw new UseOfUnknownVariableException("Использование несуществующей переменной.");
    }
}
