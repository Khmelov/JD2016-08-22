package by.it.akhmelev.jd02_04.matlab_with_parser.vars;

import by.it.akhmelev.jd02_04.matlab_with_parser.Error;
import by.it.akhmelev.jd02_04.matlab_with_parser.interfaces.IAdd;
import by.it.akhmelev.jd02_04.matlab_with_parser.interfaces.IDiv;
import by.it.akhmelev.jd02_04.matlab_with_parser.interfaces.IMul;
import by.it.akhmelev.jd02_04.matlab_with_parser.interfaces.ISub;

public abstract class Var implements IAdd,ISub,IMul,IDiv {
    //эти процедуры будут ЧАСТИЧНО перекрыты в подклассах VarF VarV VarM (числа, вектора и матрицы)
    //если операция не описана, то будет генерироваться указанная ошибка
    @Override
    public Var add(Var var) {
        //noinspection ThrowableInstanceNeverThrown
        new Error("Сложение невозможно");
        return var;
    }

    @Override
    public Var sub(Var var) {
        //noinspection ThrowableInstanceNeverThrown
        new Error("Вычитание невозможно");
        return var;
    }

    @Override
    public Var mul(Var var) {
        //noinspection ThrowableInstanceNeverThrown
        new Error("Умножение невозможно");
        return var;
    }

    @Override
    public Var div(Var var) {
        //noinspection ThrowableInstanceNeverThrown
        new Error("Деление невозможно");
        return var;
    }
}
