package by.it.prymshyts.matlab;

class MulOperation extends Operation implements  IMulOperation {

    @Override
    public Variable mul(Variable firstVar, Variable secondVar) {
        if (firstVar instanceof FloatVariable) {

            if (secondVar instanceof FloatVariable) {
                return mul((FloatVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return mul((FloatVariable) firstVar, (VectorVariable) secondVar);

            } else if (secondVar instanceof MatrixVariable) {
                return mul((FloatVariable) firstVar, (MatrixVariable) secondVar);
            }
        } else if (firstVar instanceof VectorVariable) {

            if (secondVar instanceof FloatVariable) {
                return mul((VectorVariable) firstVar, (FloatVariable) secondVar);
            }
        } else if (firstVar instanceof MatrixVariable) {

            if (secondVar instanceof FloatVariable) {
                return mul((MatrixVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return mul((MatrixVariable) firstVar, (VectorVariable) secondVar);

            } else if (secondVar instanceof MatrixVariable) {
                return mul((MatrixVariable) firstVar, (MatrixVariable) secondVar);
            }
        }
        return super.mul(firstVar, secondVar);
    }


    // Умножение целого.
    @Override
    public Variable mul(FloatVariable firstVar, FloatVariable secondVar) {
        return VariableFactory.getVariable(firstVar.getValue() * secondVar.getValue());
    }
    @Override
    public Variable mul(FloatVariable firstVar, VectorVariable secondVar) {
        return mul(secondVar, firstVar);
    }
    @Override
    public Variable mul(FloatVariable firstVar, MatrixVariable secondVar) {
        return mul(secondVar, firstVar);
    }

    // Умножение вектора.
    @Override
    public Variable mul(VectorVariable firstVar, FloatVariable secondVar) {
        Double mulValue = secondVar.getValue();
        Double[] result = new Double[firstVar.getValue().length];
        System.arraycopy(firstVar.getValue(), 0, result, 0, firstVar.getValue().length);

        for (int i = 0; i < result.length; i++) {
            result[i] *= mulValue;
        }

        return VariableFactory.getVariable(result);
    }

    // Умножение матрицы.
    @Override
    public Variable mul(MatrixVariable firstVar, FloatVariable secondVar) {
        Double mulValue = secondVar.getValue();
        Double[][] matrix = firstVar.getValue();
        Double[][] result = new Double[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[i][j] * mulValue;
            }
        }

        return VariableFactory.getVariable(result);
    }
    @Override
    public Variable mul(MatrixVariable firstVar, VectorVariable secondVar) {
        Double[][] matrix = firstVar.getValue();
        Double[] vector = secondVar.getValue();

        if (matrix[0].length != vector.length) {
            throw new IllegalVariableSizeException(IllegalVariableSizeExceptionState.MUL_VECTOR_AND_MATRIX);
        }

        Double[] result = new Double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            Double rowResult = 0.0;

            for (int j = 0; j < matrix[0].length; j++) {
                rowResult += matrix[i][j] * vector[j];
            }

            result[i] = rowResult;
        }

        return VariableFactory.getVariable(result);
    }
    @Override
    public Variable mul(MatrixVariable firstVar, MatrixVariable secondVar) {
        Double[][] firstMatrix = firstVar.getValue();
        Double[][] secondMatrix = secondVar.getValue();

        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalVariableSizeException(IllegalVariableSizeExceptionState.MUL_MATRIX);
        }

        int row = firstMatrix.length;
        int col = secondMatrix[0].length;
        int step = secondMatrix.length;

        Double[][] result = new Double[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = 0.0;
                for (int k = 0; k < step; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return VariableFactory.getVariable(result);
    }
}
