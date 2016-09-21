package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.Variable;
import by.it.voronovich.MathLab.Var.VariableVector;

/**
 * Класс содержит реализацию методов вычитания различных переменных
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Substruction {

    private Substruction() {
    }

    public static Variable sub(Variable var1, Variable var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Метод выполняет вычитание для двух чисел
     *
     * @param var1 число
     * @param var2 число
     * @return число
     */
    public static VariableFloat sub(VariableFloat var1, VariableFloat var2) {
        return new VariableFloat(var1.getValue() - var2.getValue());
    }

    /**
     * Метод выполняет вычитание для числа и вектора
     *
     * @param var1 число
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector sub(VariableFloat var1, VariableVector var2) {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = (-1.0)*var2.getValue()[i] + var1.getValue();
        }
        return new VariableVector(result);
    }

    /**
     * Метод выполняет вычитание для числа и матрицы
     *
     * @param var1 число
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix sub(VariableFloat var1, VariableMatrix var2) {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = (-1.0)*var2.getValue()[i][j] + var1.getValue();
            }
        }
        return new VariableMatrix(result);
    }


    /**
     * Метод выполняет вычитание для вектора и числа
     *
     * @param var1 вектор
     * @param var2 число
     * @return вектор
     */
    public static VariableVector sub(VariableVector var1, VariableFloat var2) {
        return sub(var2, var1);
    }

    /**
     * Метод выполняет вычитание для вектора и вектора
     *
     * @param var1 вектор
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector sub(VariableVector var1, VariableVector var2) {
        if (var1.getSize() == var2.getSize()) {
            double[] result = new double[var1.getSize()];
            for (int i = 0; i < var1.getSize(); i++) {
                result[i] = var1.getValue()[i] - var2.getValue()[i];
            }
            return new VariableVector(result);
        }
        else {
            System.out.println("Операция невозможна! Вектора различны по размерности.");
            return null;
        }
    }

    /**
     * Метод выполняет вычитание для вектора и матрицы
     * @param var1 вектор
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix sub(VariableVector var1, VariableMatrix var2) {
        if (var1.getSize() == var2.getRow()) {
            double[][] result = new double[var2.getRow()][var2.getCol()];
            for (int i = 0; i < var2.getCol(); i++) {
                for (int j = 0; j < var2.getRow(); j++) {
                    result[j][i] = (-1.0)*var2.getValue()[j][i] + var1.getValue()[j];
                }
            }
            return new VariableMatrix(result);
        }
        else {
            System.out.println("Операция невозможна! Вектор-столбец и матрица несоразмерны.");
            return null;
        }
    }


    /**
     * Метод выполняет вычитание для матрицы и числа
     *
     * @param var1 матрица
     * @param var2 число
     * @return матрица
     */
    public static VariableMatrix sub(VariableMatrix var1, VariableFloat var2) {
        return sub(var2, var1);
    }

    /**
     * Метод выполняет вычитание для матрицы и вектора
     *
     * @param var1 матрица
     * @param var2 вектор
     * @return матрица
     */
    public static VariableMatrix sub(VariableMatrix var1, VariableVector var2) {
        return sub(var2, var1);
    }

    /**
     * Метод выполняет вычитание для матрицы и матрицы
     *
     * @param var1 матрица
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix sub(VariableMatrix var1, VariableMatrix var2) {
        if (var1.getRow() == var2.getRow() && var1.getCol() == var2.getCol()) {
            double[][] result = new double[var1.getRow()][var1.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var1.getCol(); j++) {
                    result[i][j] = var1.getValue()[i][j] - var2.getValue()[i][j];
                }
            }
            return new VariableMatrix(result);
        }
        else {
            System.out.println("Операция невозможна! Матрицы несоразмерны.");
            return null;
        }
    }
}