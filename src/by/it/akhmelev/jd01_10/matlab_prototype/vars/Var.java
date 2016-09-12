package by.it.akhmelev.jd01_10.matlab_prototype.vars;

import by.it.akhmelev.jd01_10.matlab_prototype.Error;
import by.it.akhmelev.jd01_10.matlab_prototype.interfaces.*;

public abstract class Var implements IAdd,ISub,IMul,IDiv {
    //эти процедуры будут ЧАСТИЧНО перекрыты в подклассах VarF VarV VarM (числа, вектора и матрицы)
    //если операция не описана, то будет генерироваться указанная ошибка
    @Override
    public Var add(Var var) {
        new Error("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Деление невозможно");
        return null;
    }
}
