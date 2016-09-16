package by.it.grechishnikov.matLab.controller.operation;


import by.it.grechishnikov.matLab.model.*;

public interface IOperationable {
    Var add(String name, Var v1, Var v2) throws NotSupportedException;
    Var sub(String name, Var v1, Var v2) throws NotSupportedException;
    Var mul(String name, Var v1, Var v2) throws NotSupportedException;
    Var div(String name, Var v1, Var v2) throws NotSupportedException;
}
