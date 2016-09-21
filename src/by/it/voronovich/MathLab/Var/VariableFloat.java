package by.it.voronovich.MathLab.Var;

public class VariableFloat extends Variable {

    private double value;

    public VariableFloat(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /**
     * Конструктор преобразующий строку в объект VariableFloat
     * @param variableFloat строка
     */
    public VariableFloat(String variableFloat) {
        this.value = Double.valueOf(variableFloat);
    }


    @Override
    public String toString() {
        return String.format("%2.2f", value);
    }
}