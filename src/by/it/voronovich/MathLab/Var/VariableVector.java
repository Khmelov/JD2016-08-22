package by.it.voronovich.MathLab.Var;

import by.it.voronovich.MathLab.Parser;

public class VariableVector extends Variable {

    private double[] value;

    private int size;

    public VariableVector(double[] value) {
        this.value = new double[value.length];
        this.size = value.length;
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    /**
     * Конструктор преобразующий строку в объект типа Vector
     */
    public VariableVector(String variableVector) {
        this.value = Parser.findVector(variableVector);
        this.size = value.length;
    }

    public int getSize() {
        return size;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.value.length; i++) {
            System.out.printf("[%1d]=%-4.2f ",i+1, this.value[i]);
        }
        return "";
    }
}