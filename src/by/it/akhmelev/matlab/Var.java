package by.it.akhmelev.matlab;

/**
 * Created by user on 09.09.2016.
 */
public abstract class Var implements IOperation{
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
        if (v instanceof VarF) return sub((VarF) v);
        if (v instanceof VarV) return sub((VarV) v);
        if (v instanceof VarM) return sub((VarM) v);
        return null;
    }

    public Var sub(VarF v) {
        Log.print("Вычитание со скаляром невозможна");
        return null;
    }
    public Var sub(VarV v) {
        Log.print("Вычитание с вектором невозможна");
        return null;
    }
    public Var sub(VarM v) {
        Log.print("Вычитание с матрицей невозможна");
        return null;
    }


    @Override
    public Var mul(Var v) {
        if (v instanceof VarF) return mul((VarF) v);
        if (v instanceof VarV) return mul((VarV) v);
        if (v instanceof VarM) return mul((VarM) v);
        return null;
    }

    public Var mul(VarF v) {
        Log.print("Умножение со скаляром невозможна");
        return null;
    }
    public Var mul(VarV v) {
        Log.print("Умножение с вектором невозможна");
        return null;
    }
    public Var mul(VarM v) {
        Log.print("Умножение с матрицей невозможна");
        return null;
    }


    @Override
    public Var div(Var v) {
        if (v instanceof VarF) return div((VarF) v);
        if (v instanceof VarV) return div((VarV) v);
        if (v instanceof VarM) return div((VarM) v);
        return null;
    }

    public Var div(VarF v) {
        Log.print("Деление со скаляром невозможна");
        return null;
    }
    public Var div(VarV v) {
        Log.print("Деление с вектором невозможна");
        return null;
    }
    public Var div(VarM v) {
        Log.print("Деление с матрицей невозможна");
        return null;
    }


    
}
