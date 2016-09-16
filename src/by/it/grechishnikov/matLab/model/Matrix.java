package by.it.grechishnikov.matLab.model;


public class Matrix extends Var {
    private double[][] value;

    public Matrix(String name, double[][] value) {
        super(name);
        this.value = value;
    }

    @Override
    public Var add(Scalar var) throws NotSupportedException {
        double[][] arr = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                arr[i][j] = value[i][j] + var.getValue();
            }
        }
        return new Matrix(name, arr);
    }

    @Override
    public Matrix add(Matrix var) throws NotSupportedException {
        inspection(var);
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] + var.getValue()[i][j];
            }
        }
        return new Matrix(name, matrix);
    }

    @Override
    public Var sub(Scalar var) throws NotSupportedException {
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] - var.getValue();
            }
        }
        return new Matrix(name, matrix);
    }

    @Override
    public Matrix sub(Matrix var) throws NotSupportedException {
        inspection(var);
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] - var.getValue()[i][j];
            }
        }
        return new Matrix(name, matrix);
    }

    @Override
    public Var mul(Vector var) throws NotSupportedException {
        inspection(var);
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] * var.getValue()[i];
            }
        }
        return new Matrix(name, matrix);
    }

    @Override
    public Matrix mul(Matrix var) throws NotSupportedException {
        inspection(var);
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] * var.getValue()[i][j];
            }
        }
        return new Matrix(name, matrix);
    }

    @Override
    public Matrix div(Matrix var) throws NotSupportedException {
        inspection(var);
        double[][] matrix = new double[value.length][value.length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = value[i][j] / var.getValue()[i][j];
            }
        }
        return new Matrix(name, matrix);
    }

    private void inspection(Var v) throws NotSupportedException {
        if(v instanceof Vector) {
            Vector vector = (Vector) v;
            if(vector.getValue().length == 0) {
                throw new NotSupportedException("Нулевой размер вектора");
            } else if(vector.getValue().length != this.value.length) {
                throw new NotSupportedException("Разные размеры матрицы и вектора");
            }
        } else if(v instanceof Matrix) {
            Matrix matrix = (Matrix) v;
            if(matrix.getValue().length == 0) {
                throw new NotSupportedException("Нулевой размер матрицы");
            } else if(matrix.getValue().length != this.value.length || matrix.getValue()[0].length != this.value[0].length) {
                throw new NotSupportedException("Разные размеры матриц");
            }
        }
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public String valueToString() {
        String result = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result += String.format("%-7.2f", value[i][j]);
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public String toString() {

        return super.toString() + "\n" + valueToString();
    }
}
