package by.it.voronovich.JD02_06.Operation;

import by.it.voronovich.JD02_06.UnsupportedException;
import by.it.voronovich.JD02_06.Var.Variable;
import by.it.voronovich.JD02_06.Var.VariableFloat;
import by.it.voronovich.JD02_06.Var.VariableMatrix;
import by.it.voronovich.JD02_06.Var.VariableVector;
import by.it.voronovich.JD02_06.VarFactory.FloatFactory;
import by.it.voronovich.JD02_06.VarFactory.MatrixFactory;
import by.it.voronovich.JD02_06.VarFactory.VariableFactory;
import by.it.voronovich.JD02_06.VarFactory.VectorFactory;

/**
 * @author Voronovich Dmitry
 * @version 1.2
 */
public class Addition {

    private VariableFactory[] factory = {new FloatFactory(), new VectorFactory(), new MatrixFactory()};

    public Variable addition(Variable var1, Variable var2) throws UnsupportedException {

        if (var1 instanceof VariableFloat) {
            if (var2 instanceof VariableFloat) {
                return addition((VariableFloat) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return addition((VariableFloat) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                return addition((VariableFloat) var1, (VariableMatrix) var2);
            }
        } else if (var1 instanceof VariableVector) {
            if (var2 instanceof VariableFloat) {
                return addition((VariableVector) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                return addition((VariableVector) var1, (VariableVector) var2);
            } else if (var2 instanceof VariableMatrix) {
                System.out.println("Сложение невозможно");
            }
        } else if (var1 instanceof VariableMatrix) {
            if (var2 instanceof VariableFloat) {
                return addition((VariableMatrix) var1, (VariableFloat) var2);
            } else if (var2 instanceof VariableVector) {
                System.out.println("Сложение невозможно");
            } else if (var2 instanceof VariableMatrix) {
                return addition((VariableMatrix) var1, (VariableMatrix) var2);
            }
        } else {
            System.out.println("Сложение невозможно");
        }
        return null;
    }

    private VariableFloat addition(VariableFloat value1, VariableFloat value2) {
        VariableFloat add = (VariableFloat)factory[0].createVariable();
        add.setValue(value1.getValue() + value2.getValue());
        return new VariableFloat(value1.getValue() + value2.getValue());
    }

    private VariableMatrix addition(VariableFloat value1, VariableMatrix value2) {
        VariableMatrix add = (VariableMatrix)factory[2].createVariable();
        add.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                add.getValue()[i][j] = value1.getValue() + value2.getValue()[i][j];
            }
        }
        return add;
    }

    private VariableMatrix addition(VariableMatrix value1, VariableFloat value2) {
        return addition(value2, value1);
    }

    private VariableVector addition(VariableFloat value1, VariableVector value2) {
        VariableVector add = (VariableVector)factory[1].createVariable();
        add.setValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            add.getValue()[i] = value1.getValue() + value2.getValue()[i];
        }
        return add;
    }

    private VariableVector addition(VariableVector value1, VariableFloat value2) {
        return addition(value2, value1);
    }

    private VariableVector addition(VariableVector value1, VariableVector value2) throws UnsupportedException {
        VariableVector add = (VariableVector)factory[1].createVariable();
        add.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length){
            for (int i = 0; i < value1.getValue().length; i++) {
                add.getValue()[i] = value1.getValue()[i] + value2.getValue()[i];
            }
        } else {
            throw new UnsupportedException("Размеры векторов не корректны.");
        }
        return add;
    }

    private VariableMatrix addition(VariableMatrix value1, VariableMatrix value2) throws UnsupportedException {
        VariableMatrix add = (VariableMatrix)factory[2].createVariable();
        add.setValue(value1.getValue().length);
        if (value1.getValue().length == value2.getValue().length && value1.getValue()[0].length == value2.getValue()[0].length) {
            for (int i = 0; i < value1.getValue().length; i++) {
                for (int j = 0; j < value1.getValue().length; j++) {
                    add.getValue()[i][j] = value1.getValue()[i][j] + value2.getValue()[i][j];
                }
            }
        } else {
            throw new UnsupportedException("Размеры матриц не корректны.");
        }
        return add;
    }
}