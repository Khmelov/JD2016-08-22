package by.it.voronovich.JD02_06.VarFactory;

import by.it.voronovich.JD02_06.Var.VariableFloat;

public class FloatFactory extends VariableFactory{

    @Override
    public VariableFloat createVariable() {
        return new VariableFloat();
    }

    @Override
    public VariableFloat createVariable(String var) {
        return new VariableFloat(var);
    }
}


