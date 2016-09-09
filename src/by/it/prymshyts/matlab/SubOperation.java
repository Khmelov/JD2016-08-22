package by.it.prymshyts.matlab;

public class SubOperation extends Operation implements ISubOperation {

    @Override
    public Variable sub(Variable firstVar, Variable secondVar) {
        if (firstVar instanceof FloatVariable) {

            if (secondVar instanceof FloatVariable) {
                return sub((FloatVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return sub((FloatVariable) firstVar, (VectorVariable) secondVar);

            } else if (secondVar instanceof  MatrixVariable) {
                return sub((FloatVariable) firstVar, (MatrixVariable) secondVar);
            }
        } else if (firstVar instanceof VectorVariable) {

            if (secondVar instanceof FloatVariable) {
                return sub((VectorVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof VectorVariable) {
                return sub((VectorVariable) firstVar, (VectorVariable) secondVar);
            }
        } else if (firstVar instanceof MatrixVariable) {

            if (secondVar instanceof FloatVariable) {
                return sub((MatrixVariable) firstVar, (FloatVariable) secondVar);

            } else if (secondVar instanceof MatrixVariable) {
                return sub((MatrixVariable) firstVar, (MatrixVariable) secondVar);
            }
        }
        return super.sub(firstVar, secondVar);
    }


    // Вычитания от целого.
    @Override
    public Variable sub(FloatVariable firstVar, FloatVariable secondVar) {
        return new FloatVariable(firstVar.getValue() - secondVar.getValue());
    }
    @Override
    public Variable sub(FloatVariable firstVar, VectorVariable secondVar) {
        return sub(secondVar, firstVar);
    }
    @Override
    public Variable sub(FloatVariable firstVar, MatrixVariable secondVar) {
        return sub(secondVar, firstVar);
    }

    // Вычитания от вектора.
    @Override
    public Variable sub(VectorVariable firstVar, FloatVariable secondVar) {
        Double subValue = secondVar.getValue();
        Double[] result = new Double[firstVar.getValue().length];
        System.arraycopy(firstVar.getValue(), 0, result, 0, firstVar.getValue().length);

        for (int i = 0; i < result.length; i++) {
            result[i] -= subValue;
        }

        return new VectorVariable(result);
    }
    @Override
    public Variable sub(VectorVariable firstVar, VectorVariable secondVar) {
        Double[] firstVector = firstVar.getValue();
        Double[] secondVector = secondVar.getValue();

        if (firstVector.length == secondVector.length) {
            Double[] result = new Double[firstVector.length];

            for (int i = 0; i < result.length; i++) {
                result[i] = firstVector[i] - secondVector[i];
            }

            return new VectorVariable(result);
        } else {
            Log.print("Размеры векторов не соответствуют друг другу.");
            return null;
        }
    }

    // Вычитания от матрицы.
    @Override
    public Variable sub(MatrixVariable firstVar, FloatVariable secondVar) {
        Double subValue = secondVar.getValue();
        Double[][] matrix = firstVar.getValue();
        Double[][] result = new Double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] - subValue;
            }
        }

        return new MatrixVariable(result);
    }
    @Override
    public Variable sub(MatrixVariable firstVar, MatrixVariable secondVar) {
        Double[][] firstMatrix = firstVar.getValue();
        Double[][] secondMatrix = firstVar.getValue();

        if (firstMatrix.length == secondMatrix.length && firstMatrix[0].length == secondMatrix[0].length) {
            Double[][] result = new Double[firstMatrix.length][firstMatrix[0].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = firstVar.getValue()[i][j] - secondVar.getValue()[i][j];
                }
            }

            return new MatrixVariable(result);
        } else {
            Log.print("Размер матриц не соответствуют.");
            return null;
        }
    }
}
