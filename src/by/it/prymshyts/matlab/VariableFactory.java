package by.it.prymshyts.matlab;

class VariableFactory {

    static Variable getVariable(Object value) {
        Variable variable = null;

        if (value instanceof Double) {
            variable = new FloatVariable((Double) value);
        } else if (value instanceof Double[]) {
            variable = new VectorVariable((Double[]) value);
        } else if (value instanceof Double[][]) {
            variable = new MatrixVariable((Double[][]) value);
        }

        return variable;
    }
}
