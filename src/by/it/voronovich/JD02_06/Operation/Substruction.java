package by.it.voronovich.JD02_06.Operation;

import by.it.voronovich.JD02_06.UnsupportedException;
import by.it.voronovich.JD02_06.Var.Variable;
import by.it.voronovich.JD02_06.Var.VariableFloat;
import by.it.voronovich.JD02_06.Var.VariableMatrix;
import by.it.voronovich.JD02_06.Var.VariableVector;

/**
 * @author Voronovich Dmitry
 * @version 1.1
 */
public class Substruction {

    public Variable substraction(Variable var1, Variable var2) throws UnsupportedException {
        if (var1 instanceof VariableFloat) {
            if (var2 instanceof VariableFloat) {
                return substraction((VariableFloat) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return substraction((VariableFloat) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                return substraction((VariableFloat) var1, (VariableMatrix) var2);
            }
        } else if (var1 instanceof VariableVector) {
            if (var2 instanceof VariableFloat) {
                return substraction((VariableVector) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return substraction((VariableVector) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                System.out.println("Вычитание невозможно");
            }
        } else if (var1 instanceof VariableMatrix) {
            if (var2 instanceof VariableFloat) {
                return substraction((VariableMatrix) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                System.out.println("Вычитание невозможно");
            } else if (var2 instanceof VariableMatrix) {
                return substraction((VariableMatrix) var1, (VariableMatrix) var2);
            }
        } else {
            System.out.println("Вычитание невозможно");
        }
        return null;
    }

    private VariableFloat substraction(VariableFloat value1, VariableFloat value2) {
        return new VariableFloat(value1.getValue() - value2.getValue());
    }

    private VariableMatrix substraction(VariableMatrix value1, VariableFloat value2) {
        VariableMatrix sub = new VariableMatrix(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value1.getValue().length; j++) {
                sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue();
            }
        }
        return sub;
    }
    private VariableMatrix substraction(VariableFloat value1, VariableMatrix value2) throws UnsupportedException {
        return (VariableMatrix)new Addition().addition(value1, new Multiplication().multiplication(new VariableFloat(-1), value2));
    }

    private VariableVector substraction(VariableVector value1, VariableFloat value2) {
        VariableVector sub = new VariableVector(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            sub.getValue()[i] = value1.getValue()[i] - value2.getValue();
        }
        return sub;
    }

    private VariableVector substraction(VariableFloat value1, VariableVector value2) throws UnsupportedException {
        return (VariableVector)new Addition().addition(value1, new Multiplication().multiplication(new VariableFloat(-1), value2));
    }

    private VariableVector substraction(VariableVector value1, VariableVector value2) throws UnsupportedException {
        VariableVector sub = new VariableVector(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                sub.getValue()[i] = value1.getValue()[i] - value2.getValue()[i];
            }
        }
        else throw new UnsupportedException("Разные размеры векторов!");
        return sub;
    }

    private VariableMatrix substraction(VariableMatrix value1, VariableMatrix value2) throws UnsupportedException {
        VariableMatrix sub = new VariableMatrix(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value1.getValue().length; j++) {
                    sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue()[i][j];
                }
            }
        }
        else {
            throw new UnsupportedException("Разные размеры матриц.");
        }
        return sub;
    }
}