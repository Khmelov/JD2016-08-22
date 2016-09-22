package by.it.voronovich.MathLab.Operation;

import by.it.voronovich.MathLab.Var.VariableMatrix;
import by.it.voronovich.MathLab.Var.VariableFloat;
import by.it.voronovich.MathLab.Var.Variable;
import by.it.voronovich.MathLab.Var.VariableVector;
import by.it.voronovich.MathLab.UnsupportedException;

public class Operation {

    private Operation() {
    }

    /**
     * Метод суммирует две переменные
     *
     * @param var1 первая переменная
     * @param var2 вторая переменная
     * @return сумма
     */
    public static Variable add(Variable var1, Variable var2) throws UnsupportedException{
        if (var1 instanceof VariableFloat && var2 instanceof VariableFloat)
            return Addition.add((VariableFloat) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableVector)
            return Addition.add((VariableFloat) var1, (VariableVector) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableMatrix)
            return Addition.add((VariableFloat) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableVector && var2 instanceof VariableFloat)
            return Addition.add((VariableVector) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableVector)
            return Addition.add((VariableVector) var1, (VariableVector) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableMatrix)
            return Addition.add((VariableVector) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableMatrix && var2 instanceof VariableFloat)
            return Addition.add((VariableMatrix) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableVector)
            return Addition.add((VariableMatrix) var1, (VariableVector) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableMatrix)
            return Addition.add((VariableMatrix) var1, (VariableMatrix) var2);
        else
            return Addition.add(var1, var2);
    }

    /**
     * Метод вычитает переменные
     *
     * @param var1 первая переменная
     * @param var2 вторая переменная
     * @return результат
     */
    public static Variable sub(Variable var1, Variable var2) throws UnsupportedException{
        if (var1 instanceof VariableFloat && var2 instanceof VariableFloat)
            return Substruction.sub((VariableFloat) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableVector)
            return Substruction.sub((VariableFloat) var1, (VariableVector) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableMatrix)
            return Substruction.sub((VariableFloat) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableVector && var2 instanceof VariableFloat)
            return Substruction.sub((VariableVector) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableVector)
            return Substruction.sub((VariableVector) var1, (VariableVector) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableMatrix)
            return Substruction.sub((VariableVector) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableMatrix && var2 instanceof VariableFloat)
            return Substruction.sub((VariableMatrix) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableVector)
            return Substruction.sub((VariableMatrix) var1, (VariableVector) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableMatrix)
            return Substruction.sub((VariableMatrix) var1, (VariableMatrix) var2);
        else
            return Substruction.sub(var1, var2);
    }
    /**
     * Метод умножает две переменные
     *
     * @param var1 первая переменная
     * @param var2 вторая переменная
     * @return результат
     */
    public static Variable mult(Variable var1, Variable var2) throws UnsupportedException{
        if (var1 instanceof VariableFloat && var2 instanceof VariableFloat)
            return Multiplication.mult((VariableFloat) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableVector)
            return Multiplication.mult((VariableFloat) var1, (VariableVector) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableMatrix)
            return Multiplication.mult((VariableFloat) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableVector && var2 instanceof VariableFloat)
            return Multiplication.mult((VariableVector) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableVector)
            return Multiplication.mult((VariableVector) var1, (VariableVector) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableMatrix)
            return Multiplication.mult((VariableVector) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableMatrix && var2 instanceof VariableFloat)
            return Multiplication.mult((VariableMatrix) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableVector)
            return Multiplication.mult((VariableMatrix) var1, (VariableVector) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableMatrix)
            return Multiplication.mult((VariableMatrix) var1, (VariableMatrix) var2);
        else
            return Multiplication.mult(var1, var2);
    }

    /**
     * Метод делит одну переменную на другую
     *
     * @param var1 первая переменная
     * @param var2 вторая переменная
     * @return результат
     */
    public static Variable div(Variable var1, Variable var2) throws UnsupportedException{
        if (var1 instanceof VariableFloat && var2 instanceof VariableFloat)
            return Division.div((VariableFloat) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableVector)
            return Division.div((VariableFloat) var1, (VariableVector) var2);
        else if (var1 instanceof VariableFloat && var2 instanceof VariableMatrix)
            return Division.div((VariableFloat) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableVector && var2 instanceof VariableFloat)
            return Division.div((VariableVector) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableVector)
            return Division.div((VariableVector) var1, (VariableVector) var2);
        else if (var1 instanceof VariableVector && var2 instanceof VariableMatrix)
            return Division.div((VariableVector) var1, (VariableMatrix) var2);

        else if (var1 instanceof VariableMatrix && var2 instanceof VariableFloat)
            return Division.div((VariableMatrix) var1, (VariableFloat) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableVector)
            return Division.div((VariableMatrix) var1, (VariableVector) var2);
        else if (var1 instanceof VariableMatrix && var2 instanceof VariableMatrix)
            return Division.div((VariableMatrix) var1, (VariableMatrix) var2);
        else
            return Division.div(var1, var2);
    }

    /**
     * @param key переменная
     * @param var значение
     */
    public static void setKeyParameter(String key, Variable var) {
        KeyMapper.setParameter(key, var);
    }
}