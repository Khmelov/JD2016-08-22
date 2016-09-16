package by.it.grechishnikov.matLab.controller.operation;

import by.it.grechishnikov.matLab.model.*;

class Mul extends Operation {

    @Override
    public Var mul(String name, Var var1, Var var2) {
        System.out.println("Операция невозможна");
        return null;
    }

    public static Var mul(String name, Scalar var1, Scalar var2) throws NotSupportedException {
        return new Scalar(name, var1.getValue() * var2.getValue());
    }

    public static Var mul(String name, Scalar var1, Vector var2) throws NotSupportedException {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] * var1.getValue();
        }
        return new Vector(name, result);
    }

    public static Var mul(String name, Scalar var1, Matrix var2) throws NotSupportedException {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] * var1.getValue();
            }
        }
        return new Matrix(name, result);
    }

    public static Var mul(String name, Vector var1, Scalar var2) throws NotSupportedException {
        return mul(name, var2, var1);
    }

    public static Var mul(String name, Vector var1, Vector var2) throws NotSupportedException {
        if (var1.getSize() == var2.getSize()) {
            double result = 0;
            for (int i = 0; i < var1.getSize(); i++) {
                result += var1.getValue()[i] * var2.getValue()[i];
            }
            return new Scalar(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }

    public static Var mul(String name, Vector var1, Matrix var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var mul(String name, Matrix var1, Scalar var2) throws NotSupportedException {
        return mul(name, var2, var1);
    }

    public static Var mul(String name, Matrix mat, Vector vec) throws NotSupportedException {
        if (vec.getSize() == mat.getCol()) {
            double[] result = new double[mat.getRow()];
            for (int i = 0; i < mat.getRow(); i++) {
                for (int j = 0; j < mat.getCol(); j++) {
                    result[i] += mat.getValue()[i][j] * vec.getValue()[i];
                }
            }
            return new Vector(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }

    public static Var mul(String name, Matrix var1, Matrix var2) throws NotSupportedException {
        if (var1.getCol() == var2.getRow()) {
            double[][] result = new double[var1.getRow()][var2.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var2.getCol(); j++) {
                    for (int k = 0; k < var2.getRow(); k++) {
                        result[i][j] += var1.getValue()[i][k] * var2.getValue()[k][j];
                    }
                }
            }
            return new Matrix(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }
}