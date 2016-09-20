package by.it.grechishnikov.jd01_13.matLab.model;


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
