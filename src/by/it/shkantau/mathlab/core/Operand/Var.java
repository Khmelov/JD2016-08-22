package by.it.shkantau.mathlab.core.Operand;


import by.it.shkantau.mathlab.core.Operator.IAdd;
import by.it.shkantau.mathlab.core.Operator.IDiv;
import by.it.shkantau.mathlab.core.Operator.IMul;
import by.it.shkantau.mathlab.core.Operator.ISub;

/**
 * Created by Aliaksei on 10.09.2016.
 */
public abstract class Var implements IVariable, IAdd, ISub, IMul, IDiv {

    @Override
    public Var add (Var v) {
        new Error("Addition is impossible!");
        return null;
    }

    @Override
    public Var sub(Var v) {
        new Error("Subtraction is impossible!");
        return null;
    }

    @Override
    public Var mul(Var v) {
        new Error("Multiplication is impossible!");
        return null;
    }

    @Override
    public Var div(Var v) {
        new Error("Division is impossible!");
        return null;
    }

}
