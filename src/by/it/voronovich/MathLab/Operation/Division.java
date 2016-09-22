package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.Variable;
import by.it.voronovich.MathLab.Var.VariableVector;
import by.it.voronovich.MathLab.UnsupportedException;
/**
 * Класс содержит реализацию методов деления  различных переменных
 *
 * @author Voronovich Dmitry
 * @version 1.0
 */
public class Division {

    private Division() {
    }

    public static Variable div(Variable var1, Variable var2) {
        System.out.println("Операция не возможна!");
        return null;
    }

    /**
     * Делит число на число
     *
     * @param var1 число
     * @param var2 число
     * @return число
     */
    public static VariableFloat div(VariableFloat var1, VariableFloat var2) throws UnsupportedException {
        if(var2.getValue()!=0) {
            return new VariableFloat(var1.getValue() / var2.getValue());
        } else throw new UnsupportedException("Нельзя делить на ноль!");
    }

    public static Variable div(VariableFloat var1, VariableVector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    public static Variable div(VariableFloat var1, VariableMatrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит вектор на число
     *
     * @param var1 вектор
     * @param var2 число
     * @return вектор
     */
    public static VariableVector div(VariableVector var1, VariableFloat var2) {
        int sizeVector = var1.getValue().length;
        double[] result = new double[sizeVector];
        for (int i = 0; i < sizeVector; i++) {
            result[i] = var1.getValue()[i] / var2.getValue();
        }
        return new VariableVector(result);
    }

    /**
     * Делит вектор на вектор
     *
     * @param var1
     * @param var2
     */
    public static Variable div(VariableVector var1, VariableVector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит вектор на матрицу
     *
     * @param var1
     * @param var2
     */
    public static Variable div(VariableVector var1, VariableMatrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    /**
     * Делит матрицу на скаляр
     *
     * @param var1 матрица
     * @param var2 число
     * @return матрица
     */
    public static VariableMatrix div(VariableMatrix var1, VariableFloat var2) {
        double[][] result = new double[var1.getRow()][var1.getCol()];
        for (int i = 0; i < var1.getRow(); i++) {
            for (int j = 0; j < var1.getCol(); j++) {
                result[i][j] = var1.getValue()[i][j] / var2.getValue();
            }
        }
        return new VariableMatrix(result);
    }

    public static Variable div(VariableMatrix var1, VariableVector var2) {
        System.out.println("Операция невозможна.");
        return null;
    }

    public static Variable div(VariableMatrix var1, VariableMatrix var2) {
        System.out.println("Операция невозможна.");
        return null;
    }
}