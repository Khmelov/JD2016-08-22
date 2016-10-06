package by.it.grechishnikov.matLab.model;


import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double... value) {
        this.value = value;
    }

    public Vector(String name, double... value) {
        super(name);
        this.value = value;
        this.alive = true;
    }

    public int getSize() {
        return value.length;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    public String valueToString() {
        return Arrays.toString(value).replace("[", "{").replace("]", "}");
    }

    @Override
    public String toString() {
        return super.toString() + valueToString();
    }
}
