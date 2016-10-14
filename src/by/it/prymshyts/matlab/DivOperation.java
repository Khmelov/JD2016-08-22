package by.it.prymshyts.matlab;

class DivOperation extends Operation implements IDivOperation {

    @Override
    public Variable div(Variable firstVar, Variable secondVar) {
        if (firstVar instanceof FloatVariable) {

            if (secondVar instanceof FloatVariable) {
                return div((FloatVariable) firstVar, (FloatVariable) secondVar);
            }
        } else if (firstVar instanceof VectorVariable) {

            if (secondVar instanceof FloatVariable) {
                return div((VectorVariable) firstVar, (FloatVariable) secondVar);
            }
        } else if (firstVar instanceof MatrixVariable) {

            if (secondVar instanceof FloatVariable) {
                return div((MatrixVariable) firstVar, (FloatVariable) secondVar);
            }
        }
        return super.div(firstVar, secondVar);
    }


    // Деление целого.
    @Override
    public Variable div(FloatVariable firstVar, FloatVariable secondVar) {
        if (secondVar.getValue() == 0) {
            throw new DivisionByZeroException(DivisionByZeroExceptionState.DIVISION_BY_ZERO);
        }
        return VariableFactory.getVariable(firstVar.getValue() / secondVar.getValue());
    }

    // Деление вектора.
    @Override
    public Variable div(VectorVariable firstVar, FloatVariable secondVar) {
        Double divValue = secondVar.getValue();
        Double[] result = new Double[firstVar.getValue().length];
        System.arraycopy(firstVar.getValue(), 0, result, 0, firstVar.getValue().length);

        if (divValue == 0) {
            throw new DivisionByZeroException(DivisionByZeroExceptionState.DIVISION_BY_ZERO);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] /= divValue;
        }

        return VariableFactory.getVariable(result);
    }

    // Деление матрицы.
    @Override
    public Variable div(MatrixVariable firstVar, FloatVariable secondVar) {
        Double divValue = secondVar.getValue();
        Double[][] matrix = firstVar.getValue();
        Double[][] result = new Double[matrix.length][matrix[0].length];

        if (divValue == 0) {
            throw new DivisionByZeroException(DivisionByZeroExceptionState.DIVISION_BY_ZERO);
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[i][j] / divValue;
            }
        }

        return VariableFactory.getVariable(result);
    }
}
