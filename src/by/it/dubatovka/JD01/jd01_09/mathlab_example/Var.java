package by.it.dubatovka.JD01.jd01_09.mathlab_example;

/**
 * Created by user on 09.09.2016.
 */
public abstract class Var implements IOperation {
    @Override
    public Var add(Var v) {
        if (v instanceof VarF) return add((VarF) v);
        if (v instanceof VarV) return add((VarV) v);
        if (v instanceof VarM) return add((VarM) v);
        return null;
    }

    public Var add(VarF v) {
        Log.print("Сложение со скаляром невозможна");
        return null;
    }
    public Var add(VarV v) {
        Log.print("Сложение с вектором невозможна");
        return null;
    }
    public Var add(VarM v) {
        Log.print("Сложение с матрицей невозможна");
        return null;
    }


    @Override
    public Var sub(Var v) {
        return null;
    }

    @Override
    public Var mul(Var v) {
        return null;
    }

    @Override
    public Var div(Var v) {
        return null;
    }
}
