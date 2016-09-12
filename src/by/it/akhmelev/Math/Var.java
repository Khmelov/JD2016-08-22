package by.it.akhmelev.Math;

public class Var implements IOperable{
    public Var() {
        Log.print("Создана переменная");
    }
    public Var(double f) {
        Log.print("Создан скаляр");
    }

    public Var(double[] v) {
        Log.print("Создан вектор");
    }

    public Var(double[][] m) {
        Log.print("Создана матрица");
    }


    @Override
    public Var add(Var v) {
        System.out.println("Операция add невозможна");
        return null;
    }

    @Override
    public Var sub(Var v) {
        System.out.println("Операция sub невозможна");
        return null;
    }

    @Override
    public Var mul(Var v) {
        System.out.println("Операция mul невозможна");
        return null;
    }

    @Override
    public Var div(Var v) {
        System.out.println("Операция div невозможна");
        return null;
    }
}
