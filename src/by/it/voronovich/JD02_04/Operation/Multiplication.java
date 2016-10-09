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
public class Multiplication {

    public Variable multiplication(Variable var1, Variable var2) throws UnsupportedException {

        if (var1 instanceof VariableFloat) {
            if (var2 instanceof VariableFloat) {
                return multiplication((VariableFloat) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return multiplication((VariableFloat) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                return multiplication((VariableFloat) var1, (VariableMatrix) var2);
            }
        } else if (var1 instanceof VariableVector) {
            if (var2 instanceof VariableFloat) {
                return multiplication((VariableVector) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return multiplication((VariableVector) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                System.out.println("Умножение невозможно");
            }
        } else if (var1 instanceof VariableMatrix) {
            if (var2 instanceof VariableFloat) {
                return multiplication((VariableMatrix) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return multiplication((VariableMatrix) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                return multiplication((VariableMatrix) var1, (VariableMatrix) var2);
            }
        } else {
            System.out.println("Умножение невозможно");
        }
        return null;
    }

    private VariableFloat multiplication(VariableFloat value1, VariableFloat value2) {
        return new VariableFloat(value1.getValue() * value2.getValue());
    }

    private VariableMatrix multiplication(VariableFloat value1, VariableMatrix value2) {
        VariableMatrix multi = new VariableMatrix(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                multi.getValue()[i][j] = value1.getValue() * value2.getValue()[i][j];
            }
        }
        return multi;
    }

    private VariableMatrix multiplication(VariableMatrix value1, VariableFloat value2) {
        return multiplication(value2, value1);
    }

    private VariableVector multiplication(VariableFloat value1, VariableVector value2) {
        VariableVector multi = new VariableVector(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            multi.getValue()[i] = value1.getValue() * value2.getValue()[i];
        }
        return multi;
    }

    private VariableVector multiplication(VariableVector value1, VariableFloat value2) {
        return multiplication(value2, value1);
    }

    private VariableFloat multiplication(VariableVector value1, VariableVector value2) throws UnsupportedException {
        VariableFloat multi = new VariableFloat();
        if (value1.getValue().length == value2.getValue().length) {
            double m = 0;
            for (int i = 0; i < value1.getValue().length; i++) {
                m += value1.getValue()[i] * value2.getValue()[i];
            }
            multi.setValue(m);
        } else {
            throw new UnsupportedException("Размеры векторов не совпадают.");
        }
        return multi;
    }

    private VariableMatrix multiplication(VariableMatrix value1, VariableMatrix value2) throws UnsupportedException {
        VariableMatrix multi = new VariableMatrix(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value2.getValue()[0].length; j++) {
                    for (int k = 0; k < value2.getValue().length; k++) {
                        multi.getValue()[i][j] = multi.getValue()[i][j] + value1.getValue()[i][k] * value2.getValue()[k][j];
                    }
                }
            }
        } else {
            throw new UnsupportedException("Размеры матриц не совпадают.");
        }
        return multi;
    }

    private VariableVector multiplication(VariableMatrix value1, VariableVector value2) {
        VariableVector multi = new VariableVector(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                multi.getValue()[i] = multi.getValue()[i] + value1.getValue()[i][j] * value2.getValue()[j];
            }
        }
        return multi;
    }

}