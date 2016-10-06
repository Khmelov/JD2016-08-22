package by.it.aborisenok.matLab.Interfaces;

import by.it.aborisenok.matLab.Vars.Var;

/**
 * Created by Лёша on 09.09.2016.
 */
public interface IOperation {
    Var add(Var v);
    Var sub(Var v);
    Var mul(Var v);
    Var div(Var V);
    void assigned(String name, Var var);
}
