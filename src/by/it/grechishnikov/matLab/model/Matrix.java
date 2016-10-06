package by.it.grechishnikov.matLab.model;


public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String name, double[][] value) {
        super(name);
        this.value = value;
        this.alive = true;
    }

    public int getRow() {
        return value.length;
    }

    public int getCol() {
        return value[0].length;
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public String valueToString() {
        String result = "{";
        for (int i = 0; i < value.length; i++) {
            result += "{";
            for (int j = 0; j < value[i].length; j++) {
                result += String.format("%.1f!", value[i][j]);
            }
            result = result.substring(0, result.length() - 1);
            result += "}!";
        }
        result = result.substring(0, result.length() - 1) + "}";
        result = result.replace(",", ".");
        result = result.replace("!", ",");
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + valueToString();
    }
}
