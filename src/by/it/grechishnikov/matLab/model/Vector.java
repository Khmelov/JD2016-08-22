package by.it.grechishnikov.matLab.model;


import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(String name, double... value) {
        super(name);
        this.value = value;
    }

    @Override
    public Var add(Scalar var) throws NotSupportedException {
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] + var.getValue();
        }
        return new Vector(name, arr);
    }

    @Override
    public Vector add(Vector var) throws NotSupportedException {
        inspection(var);
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] + var.getValue()[i];
        }
        return new Vector(name, arr);
    }

    @Override
    public Var sub(Scalar var) throws NotSupportedException {
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] - var.getValue();
        }
        return new Vector(name, arr);
    }

    @Override
    public Vector sub(Vector var) throws NotSupportedException {
        inspection(var);
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] - var.getValue()[i];
        }
        return new Vector(name, arr);
    }

    @Override
    public Var mul(Scalar var) throws NotSupportedException {
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] * var.getValue();
        }
        return new Vector(name, arr);
    }

    @Override
    public Vector mul(Vector var) throws NotSupportedException {
        inspection(var);
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] * var.getValue()[i];
        }
        return new Vector(name, arr);
    }

    @Override
    public Var div(Scalar var) throws NotSupportedException {
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] / var.getValue();
        }
        return new Vector(name, arr);
    }

    @Override
    public Vector div(Vector var) throws NotSupportedException {
        inspection(var);
        double[] arr = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] / var.getValue()[i];
        }
        return new Vector(name, arr);
    }

    private void inspection(Var v) throws NotSupportedException {
        if(v instanceof Vector) {
            Vector vector = (Vector) v;
            if(vector.getValue().length == 0) {
                throw new NotSupportedException("Нулевой размер вектора");
            } else if(vector.getValue().length != this.value.length) {
                throw new NotSupportedException("Разные размеры векторов");
            }
        } else if(v instanceof Matrix) {
            Matrix matrix = (Matrix) v;
            if(matrix.getValue().length == 0) {
                throw new NotSupportedException("Нулевой размер матрицы");
            } else if(matrix.getValue().length != this.value.length) {
                throw new NotSupportedException("Разные размеры матрицы и вектора");
            }
        }
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    public String valueToString() {
        return Arrays.toString(value) ;
    }

    @Override
    public String toString() {
        return super.toString() + valueToString() + "\n";
    }
}
