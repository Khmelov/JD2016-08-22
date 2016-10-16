package by.it.voronovich.JD02_06.VarFactory;

import by.it.voronovich.JD02_06.Var.VariableMatrix;

public class MatrixFactory extends VariableFactory {

    @Override
    public VariableMatrix createVariable(String var) {
        return new VariableMatrix(var);
    }

    @Override
    public VariableMatrix createVariable() {
        return new VariableMatrix();
    }


}
