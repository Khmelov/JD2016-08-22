package by.it.prymshyts.jd01.jd01_13.matlab;

public class AddOperation extends Operation implements IAddOperation {

    @Override
    public Variable add(Variable firstVar, Variable secondVar) {
        if (firstVar instanceof FloatVariable) {

            if (secondVar instanceof FloatVariable) {
                return add((FloatVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return add((FloatVariable) firstVar, (VectorVariable) secondVar);

            } else if (secondVar instanceof  MatrixVariable) {
                return add((FloatVariable) firstVar, (MatrixVariable) secondVar);
            }
        } else if (firstVar instanceof VectorVariable) {

            if (secondVar instanceof FloatVariable) {
                return add((VectorVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return add((VectorVariable) firstVar, (VectorVariable) secondVar);
            }
        } else if (firstVar instanceof MatrixVariable) {

            if (secondVar instanceof FloatVariable) {
                return add((MatrixVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof MatrixVariable) {
                return add((MatrixVariable) firstVar, (MatrixVariable) secondVar);
            }
        }
        return super.add(firstVar, secondVar);
    }


    // Сложение к целому.
    @Override
    public Variable add(FloatVariable firstVar, FloatVariable secondVar) {
        return new FloatVariable(firstVar.getValue() + secondVar.getValue());
    }
    @Override
    public Variable add(FloatVariable firstVar, VectorVariable secondVar) {
        return add(secondVar, firstVar);
    }
    @Override
    public Variable add(FloatVariable firstVar, MatrixVariable secondVar) {
        return add(secondVar, firstVar);
    }

    // Сложение к вектору.
    @Override
    public Variable add(VectorVariable firstVar, FloatVariable secondVar) {
        Double addValue = secondVar.getValue();
        Double[] result = new Double[firstVar.getValue().length];
        System.arraycopy(firstVar.getValue(), 0, result, 0, firstVar.getValue().length);

        for (int i = 0; i < result.length; i++) {
            result[i] += addValue;
        }

        return new VectorVariable(result);
    }
    @Override
    public Variable add(VectorVariable firstVar, VectorVariable secondVar) {
        Double[] firstVector = firstVar.getValue();
        Double[] secondVector = secondVar.getValue();

        if (firstVector.length != secondVector.length) {
            throw new IllegalVariableSizeException(IllegalVariableSizeExceptionState.ADD_VECTORS);
        }

        Double[] result = new Double[firstVector.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = firstVector[i] + secondVector[i];
        }

        return new VectorVariable(result);
    }

    // Сложение к матрице.
    @Override
    public Variable add(MatrixVariable firstVar, FloatVariable secondVar) {
        Double addValue = secondVar.getValue();
        Double[][] matrix = firstVar.getValue();
        Double[][] result = new Double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] + addValue;
            }
        }

        return new MatrixVariable(result);
    }
    @Override
    public Variable add(MatrixVariable firstVar, MatrixVariable secondVar) {
        Double[][] firstMatrix = firstVar.getValue();
        Double[][] secondMatrix = secondVar.getValue();

        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            throw new IllegalVariableSizeException(IllegalVariableSizeExceptionState.ADD_MATRIX);
        }

        Double[][] result = new Double[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return new MatrixVariable(result);
    }
}
