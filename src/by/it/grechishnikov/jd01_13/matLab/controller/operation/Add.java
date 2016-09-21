package by.it.grechishnikov.jd01_13.matLab.controller.operation;

import by.it.grechishnikov.jd01_13.matLab.model.*;

class Add extends Operation {

    @Override
    public Var add(String name, Var var1, Var var2){
        System.out.println("Операция невозможна");
        return null;
    }

    public static Var add(String name, Scalar var1, Scalar var2) throws NotSupportedException {
        return new Scalar(name, var1.getValue() + var2.getValue());
    }

    public static Var add(String name, Scalar var1, Vector var2) throws NotSupportedException {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] + var1.getValue();
        }
        return new Vector(name, result);
    }

    public static Var add(String name, Scalar var1, Matrix var2) throws NotSupportedException {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] + var1.getValue();
            }
        }
        return new Matrix(name, result);
    }

    public static Var add(String name, Vector var1, Scalar var2) throws NotSupportedException {
        return add(name, var2, var1);
    }

    public static Var add(String name, Vector var1, Vector var2) throws NotSupportedException {
        if (var1.getSize() == var2.getSize()) {
            double[] result = new double[var1.getSize()];
            for (int i = 0; i < var1.getSize(); i++) {
                result[i] = var1.getValue()[i] + var2.getValue()[i];
            }
            return new Vector(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }

    public static Var add(String name, Vector var1, Matrix var2) throws NotSupportedException {
        if (var1.getSize() == var2.getRow()) {
            double[][] result = new double[var2.getRow()][var2.getCol()];
            for (int i = 0; i < var2.getCol(); i++) {
                for (int j = 0; j < var2.getRow(); j++) {
                    result[j][i] = var2.getValue()[j][i] + var1.getValue()[j];
                }
            }
            return new Matrix(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }

    public static Var add(String name, Matrix var1, Scalar var2) throws NotSupportedException {
        return add(name, var2, var1);
    }

    public static Var add(String name, Matrix var1, Vector var2) throws NotSupportedException {
        return add(name, var2, var1);
    }

    public static Var add(String name, Matrix var1, Matrix var2) throws NotSupportedException {
        if (var1.getRow() == var2.getRow() && var1.getCol() == var2.getCol()) {
            double[][] result = new double[var1.getRow()][var1.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var1.getCol(); j++) {
                    result[i][j] = var1.getValue()[i][j] + var2.getValue()[i][j];
                }
            }
            return new Matrix(name, result);
        }
        else {
            throw new NotSupportedException();
        }
    }
}