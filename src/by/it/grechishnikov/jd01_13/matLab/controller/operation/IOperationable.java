package by.it.grechishnikov.jd01_13.matLab.controller.operation;


import by.it.grechishnikov.jd01_13.matLab.model.NotSupportedException;
import by.it.grechishnikov.jd01_13.matLab.model.Var;

public interface IOperationable {
    Var add(String name, Var v1, Var v2) throws NotSupportedException;
    Var sub(String name, Var v1, Var v2) throws NotSupportedException;
    Var mul(String name, Var v1, Var v2) throws NotSupportedException;
    Var div(String name, Var v1, Var v2) throws NotSupportedException;
}
