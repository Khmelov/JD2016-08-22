package by.it.voronovich.JD02_06.VarFactory;

import by.it.voronovich.JD02_06.Var.VariableVector;

public class VectorFactory extends VariableFactory {

    @Override
    public VariableVector createVariable(String var) {
        return new VariableVector(var);
    }

    @Override
    public VariableVector createVariable() {
        return new VariableVector();
    }
}
