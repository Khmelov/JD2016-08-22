package by.it.grechishnikov.matLab.model;


public class VarFactory {
    public static Var getVar(double value) {
        return new Scalar(value);
    }

    public static Var getVar(String name, double value) {
        return new Scalar(name, value);
    }

    public static Var getVar(String name, double[] value) {
        return new Vector(name, value);
    }

    public static Var getVar(String name, double[][] value) {
        return new Matrix(name, value);
    }
}
