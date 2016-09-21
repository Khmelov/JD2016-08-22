package by.it.grechishnikov.matLab.controller.operation;


import by.it.grechishnikov.matLab.model.*;

public interface IOperationable {
    <T extends Var> Var add(String name, T v1, T v2) throws NotSupportedException;
    <T extends Var> Var sub(String name, T v1, T v2) throws NotSupportedException;
    <T extends Var> Var mul(String name, T v1, T v2) throws NotSupportedException;
    <T extends Var> Var div(String name, T v1, T v2) throws NotSupportedException;
}
