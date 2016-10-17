package by.it.shkantau.mathlab.calc.Operand;


import by.it.shkantau.mathlab.calc.Operator.IAdd;
import by.it.shkantau.mathlab.calc.Operator.IDiv;
import by.it.shkantau.mathlab.calc.Operator.IMul;
import by.it.shkantau.mathlab.calc.Operator.ISub;


public abstract class Var implements IVariable, IAdd, ISub, IMul, IDiv {

    @Override
    public Var add (Var v) {
//        new Error("Addition is impossible!");
        return null;
    }

    @Override
    public Var sub(Var v) {
//        new Error("Subtraction is impossible!");
        return null;
    }

    @Override
    public Var mul(Var v) {
//        new Error("Multiplication is impossible!");
        return null;
    }

    @Override
    public Var div(Var v) {
//        new Error("Division is impossible!");
        return null;
    }
}
