package by.it.voronovich.JD02_04.Operation;

import by.it.voronovich.JD02_04.Var.VariableFloat;
import by.it.voronovich.JD02_04.Var.VariableMatrix;
import by.it.voronovich.JD02_04.Var.Variable;
import by.it.voronovich.JD02_04.Var.VariableVector;
import by.it.voronovich.JD02_04.UnsupportedException;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class Division {

    public Variable division(Variable var1, Variable var2) throws UnsupportedException {

        if (var1 instanceof VariableFloat) {
            if (var2 instanceof VariableFloat) {
                return division((VariableFloat) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                System.out.println("Деление невозможно");
            } else if (var2 instanceof VariableMatrix) {
                System.out.println("Деление невозможно");
            }
        } else if (var1 instanceof VariableVector) {
            if (var2 instanceof VariableFloat) {
                return division((VariableVector) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                System.out.println("Деление невозможно");
            } else if (var2 instanceof VariableMatrix) {
                System.out.println("Деление невозможно");
            }
        } else if (var1 instanceof VariableMatrix) {
            if (var2 instanceof VariableFloat) {
                return division((VariableMatrix) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                System.out.println("Деление невозможно");
            } else if (var2 instanceof VariableMatrix) {
                return division((VariableMatrix) var1, (VariableMatrix) var2);
            }
        } else {
            System.out.println("Деление невозможно");
        }
        return null;
    }

    private VariableFloat division(VariableFloat valueOne, VariableFloat valueTwo) throws UnsupportedException {
        VariableFloat div = new VariableFloat();
        if (valueTwo.getValue() != 0) {
            div.setValue(valueOne.getValue() / valueTwo.getValue()); }
        else {
            throw new UnsupportedException("Division on null!");
        }
        return div;
    }

    private VariableMatrix division(VariableMatrix valueOne, VariableFloat valueTwo) throws UnsupportedException {
        return (VariableMatrix)new Multiplication().multiplication(division(new VariableFloat(1), valueTwo), valueOne);
    }

    private VariableMatrix division(VariableMatrix valueOne, VariableMatrix valueTwo) throws UnsupportedException {
        return (VariableMatrix)new Multiplication().multiplication(valueOne, new VariableMatrix(inverseMatrix(valueTwo.getValue())));
    }

    public static double[][] inverseMatrix(double[][] matrix) {
        int n = matrix.length;
        double[][] array = new double[n][2 * matrix[0].length];
        int m = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < n) {
                    array[i][j] = matrix[i][j];
                } else if (j == m) {
                    array[i][m] = 1;

                } else array[i][j] = 0;
            }
            m++;
        }
        array = transformationMatrixOfGauss(array);

        double[][] inverseMat = new double[matrix.length][matrix[0].length];
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = matrix[0].length; j < 2 * matrix[0].length; j++) {
                inverseMat[i][s] = array[i][j];
                System.out.print(inverseMat[i][s]);
                s++;
            }
            s = 0;
        }
        return inverseMat;
    }

    public static double[][] transformationMatrixOfGauss(double[][] array) {
        int n = array.length;
        int m = array[0].length;
        for (int diag = 0; diag < n - 1; diag++) {
            for (int row = diag + 1; row < n; row++) {
                double k = array[row][diag] / array[diag][diag];
                for (int col = 0; col < m; col++) {
                    array[row][col] = array[row][col] - array[diag][col] * k;
                }
            }
        }
        for (int diag = n - 1; diag > 0; diag--) {
            for (int row = 0; row < diag; row++) {
                double k = array[row][diag] / array[diag][diag];
                for (int col = 0; col < m; col++) {
                    array[row][col] = array[row][col] - array[diag][col] * k;
                }
            }
        }
        return array;
    }
    private VariableVector division(VariableVector value1, VariableFloat value2) {
        VariableVector div = new VariableVector(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            div.getValue() [i] = value1.getValue()[i] / value2.getValue();
        }
        return div;
    }
}