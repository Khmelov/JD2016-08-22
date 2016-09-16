package by.it.grechishnikov.matLab.model;


public interface IOperationable {
    Var add(Var var) throws NotSupportedException;
    Var sub(Var var) throws NotSupportedException;
    Var mul(Var var) throws NotSupportedException;
    Var div(Var var) throws NotSupportedException;
    void assign();

    String toString(); //для заданий
    String valueToString(); //для работы
}
