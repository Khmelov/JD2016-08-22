package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.Variable;
import by.it.voronovich.MathLab.Var.VariableVector;

/**
 * Класс содержит реализацию методов умножения различных переменных
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Multiplication {

    private Multiplication() {
    }

    public static Variable mult(Variable var1, Variable var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Метод умножает число на число
     *
     * @param var1 число
     * @param var2 число
     * @return число
     */
    public static VariableFloat mult(VariableFloat var1, VariableFloat var2) {
        return new VariableFloat(var1.getValue() * var2.getValue());
    }

    /**
     * Метод умножает число на вектор
     *
     * @param var1 число
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector mult(VariableFloat var1, VariableVector var2) {
        int sizeVector = var2.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var2.getValue()[i] * var1.getValue();
        }
        return new VariableVector(result);
    }

    /**
     * Метод цмножает число на матрицу
     *
     * @param var1 число
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix mult(VariableFloat var1, VariableMatrix var2) {
        double[][] result = new double[var2.getRow()][var2.getCol()];
        for (int i = 0; i < var2.getRow(); i++) {
            for (int j = 0; j < var2.getCol(); j++) {
                result[i][j] = var2.getValue()[i][j] * var1.getValue();
            }
        }
        return new VariableMatrix(result);
    }


    /**
     * Умножает вектор на число
     *
     * @param var1 вектор
     * @param var2 число
     * @return вектор
     */
    public static VariableVector mult(VariableVector var1, VariableFloat var2) {
        return mult(var2, var1);
    }

    /**
     * Метод умножает вектор на вектор
     *
     * @param var1 вектор
     * @param var2 вектор
     * @return число
     */
    public static VariableFloat mult(VariableVector var1, VariableVector var2) {
        if (var1.getSize() == var2.getSize()) {
            double result = 0;
            for (int i = 0; i < var1.getSize(); i++) {
                result += var1.getValue()[i] * var2.getValue()[i];
            }
            return new VariableFloat(result);
        }
        else {
            System.out.println("Операция невозможна! Вектора несоразмерны.");
            return null;
        }
    }

    /**
     * @param var1 вектор
     * @param var2 матрица
     */
    public static Variable mult(VariableVector var1, VariableMatrix var2) {
        System.out.println("Операция невозможна!");
        return null;
    }

    /**
     * Метод умножает матрицу на число
     *
     * @param var1 матрица
     * @param var2 число
     * @return матрица
     */
    public static VariableMatrix mult(VariableMatrix var1, VariableFloat var2) {
        return mult(var2, var1);
    }

    /**
     * Метод умножает матрицу на вектор
     *
     * @param var1 матрица
     * @param var2 вектор
     * @return вектор
     */
    public static VariableVector mult(VariableMatrix var2, VariableVector var1) {
        if (var1.getSize() == var2.getCol()) {
            double[] result = new double[var2.getRow()];
            for (int i = 0; i < var2.getRow(); i++) {
                result[i] = mult(new VariableVector(var1.getValue()), new VariableVector(var2.getValue()[i])).getValue();
            }
            return new VariableVector(result);
        }
        else {
            System.out.println("Операция невозможна! Вектор-столбец и матрица несоразмерны.");
            return null;
        }
    }

    /**
     * Метод умножает матрицу на матрицу
     *
     * @param var1 матрица
     * @param var2 матрица
     * @return матрица
     */
    public static VariableMatrix mult(VariableMatrix var1, VariableMatrix var2) {
        if (var1.getCol() == var2.getRow()) {
            double[][] result = new double[var1.getRow()][var2.getCol()];
            for (int i = 0; i < var1.getRow(); i++) {
                for (int j = 0; j < var2.getCol(); j++) {
                    double[] colJ = new double[var2.getRow()];
                    for (int k = 0; k < var2.getRow(); k++) {
                        colJ[k] = var2.getValue()[k][j];
                    }
                    result[i][j] = mult(new VariableVector(var1.getValue()[i]), new VariableVector(colJ)).getValue();
                }
            }
            return new VariableMatrix(result);
        }
        else {
            System.out.println("Операция невозможна! Кол-во столбцов первого множителя не равно кол-ву строк второго множителя.");
            return null;
        }
    }
}