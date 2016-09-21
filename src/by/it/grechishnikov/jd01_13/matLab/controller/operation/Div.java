package by.it.grechishnikov.jd01_13.matLab.controller.operation;

import by.it.grechishnikov.jd01_13.matLab.model.*;

class Div extends Operation {

    @Override
    public Var div(String name, Var var1, Var var2){
        System.out.println("Операция невозможна");
        return null;
    }

    public static Var div(String name, Scalar var1, Scalar var2) throws NotSupportedException {
        return new Scalar(name, var1.getValue() / var2.getValue());
    }

    public static Var div(String name, Scalar var1, Vector var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var div(String name, Scalar var1, Matrix var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var div(String name, Vector var1, Scalar var2) throws NotSupportedException {
        int sizeVector = var1.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var1.getValue()[i] / var2.getValue();
        }
        return new Vector(name, result);
    }

    public static Var div(String name, Vector var1, Vector var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var div(String name, Vector var1, Matrix var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var div(String name, Matrix var1, Scalar var2) throws NotSupportedException {
        double[][] result = new double[var1.getRow()][var1.getCol()];
        for (int i = 0; i < var1.getRow(); i++) {
            for (int j = 0; j < var1.getCol(); j++) {
                result[i][j] = var1.getValue()[i][j] / var2.getValue();
            }
        }
        return new Matrix(name, result);
    }

    public static Var div(String name, Matrix var1, Vector var2) throws NotSupportedException {
        throw new NotSupportedException();
    }

    public static Var div(String name, Matrix var1, Matrix var2) throws NotSupportedException {
        throw new NotSupportedException();
    }
}