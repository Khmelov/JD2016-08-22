package by.it.prymshyts.matlab;

public class FloatVariable extends Variable {

    private Double value = null;

    public FloatVariable(Double value) {
        this.value = value;
    }


    @Override
    public Double getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (Double) value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
