package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.Variable;
import by.it.voronovich.MathLab.Var.VariableVector;
import by.it.voronovich.MathLab.UnsupportedException;

/**
 * Класс содержит реализацию методов сложения  различных переменных
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Addition {

    private Addition() {
    }

    public static Variable add(Variable var1, Variable var2) {
        System.err.println("Операция невозможна.");
        return null;
    }

    /**
     * Метод выполняет сложение двух чисел
     *
     * @param var1 число
     * @param var2 число
     * @return число
     */
    public static VariableFloat add(VariableFloat var1, VariableFloat var2) {
        return new VariableFloat(var1.getValue() + var2.getValue());
    }

    /**
     * Метод выполняет сложение числа и вектора
     *
     * @param var1 число
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector add(VariableFloat var1, VariableVector var2) {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] + var1.getValue();
        }
        return new VariableVector(result);
    }

    /**
     * Метод выполняет сложение числа и матрицы
     *
     * @param var1 число
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix add(VariableFloat var1, VariableMatrix var2) {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] + var1.getValue();
            }
        }
        return new VariableMatrix(result);
    }


    /**
     * Метод выполняет сложение вектора и числа
     * @param var1 вектор
     * @param var2 число
     * @return вектор
     */
    public static VariableVector add(VariableVector var1, VariableFloat var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет сложение вектора и вектора
     *
     * @param var1 вектор
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector add(VariableVector var1, VariableVector var2) {
        if (var1.getSize() == var2.getSize()) {
            double[] result = new double[var1.getSize()];
            for (int i = 0; i < var1.getSize(); i++) {
                result[i] = var1.getValue()[i] + var2.getValue()[i];
            }
            return new VariableVector(result);
        }
        else {
            System.out.println("Операция невозможна! Вектора различны по размерности.");
            return null;
        }
    }

    /**
     * Метод выполняет сложение вектора и матрицы
     *
     * @param var1 вектор
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix add(VariableVector var1, VariableMatrix var2) {
        if (var1.getSize() == var2.getRow()) {
            double[][] result = new double[var2.getRow()][var2.getCol()];
            for (int i = 0; i < var2.getCol(); i++) {
                for (int j = 0; j < var2.getRow(); j++) {
                    result[j][i] = var2.getValue()[j][i] + var1.getValue()[j];
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
     * Метод выполняет сложение матрицы и числа
     *
     * @param var1 матрица
     * @param var2 число
     * @return матрица
     */
    public static VariableMatrix add(VariableMatrix var1, VariableFloat var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет сложение матрицы и вектора
     *
     * @param var1 матрица
     * @param var2 вектор
     * @return матрица
     */
    public static VariableMatrix add(VariableMatrix var1, VariableVector var2) {
        return add(var2, var1);
    }

    /**
     * Метод выполняет сложение матрицы и матрицы
     *
     * @param var1 матрица
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix add(VariableMatrix var1, VariableMatrix var2) {
        if (var1.getRow() == var2.getRow() && var1.getCol() == var2.getCol()) {
            double[][] result = new double[var1.getRow()][var1.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var1.getCol(); j++) {
                    result[i][j] = var1.getValue()[i][j] + var2.getValue()[i][j];
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