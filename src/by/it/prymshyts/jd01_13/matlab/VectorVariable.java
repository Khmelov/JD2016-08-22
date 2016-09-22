package by.it.prymshyts.jd01_13.matlab;

import java.util.Arrays;

public class VectorVariable extends Variable {

    private Double[] value = null;

    public VectorVariable(Double[] value) {
        this.value = value;
    }


    @Override
    public Double[] getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (Double[]) value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
