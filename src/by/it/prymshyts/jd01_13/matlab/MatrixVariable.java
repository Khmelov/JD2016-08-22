package by.it.prymshyts.jd01_13.matlab;

import java.util.Arrays;

public class MatrixVariable extends Variable {

    private Double[][] value = null;

    public MatrixVariable(Double[][] value) {
        this.value = value;
    }


    @Override
    public Double[][] getValue() {
        return this.value;
    }

    @Override
    public void setValue(Object value) {
        this.value = (Double[][]) value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        String delimiter = "";

        for (Double[] element : value) {
            result.append(delimiter + Arrays.toString(element));
            delimiter = ", ";
        }
        result.append("]");

        return result.toString();
    }
}
