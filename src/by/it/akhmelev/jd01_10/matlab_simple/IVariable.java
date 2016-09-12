package by.it.akhmelev.jd01_10.matlab_simple;

public interface IVariable {
    //тут опишем основные операции
    Variable add(Variable varAdd);
    Variable sub(Variable varSub);
    Variable mul(Variable varMul);
    Variable div(Variable varDiv);

}
