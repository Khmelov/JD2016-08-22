package by.it.aborisenok.matLab.Vars;

import by.it.aborisenok.matLab.Interfaces.IOperation;
import by.it.aborisenok.matLab.Logger;

/**
 * Created by Лёша on 09.09.2016.
 */
public abstract class Var implements IOperation {



    @Override
    public Var add(Var v) {
        if (v instanceof VarF) return add((VarF) v);
        if (v instanceof VarV) return add((VarV) v);
        if (v instanceof VarM) return add((VarM) v);
        return null;
    }

    public Var add(VarF v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Сложение со скаляром невозможно"));
        return null;
    }

    public Var add(VarV v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Сложение с вектором невозможно"));
        return null;
    }
    public Var add(VarM v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Сложение с матрицей невозможно"));
        return null;
    }

    @Override
    public Var sub(Var v) {
        if (v instanceof VarF) return sub((VarF) v);
        if (v instanceof VarV) return sub((VarV) v);
        if (v instanceof VarM) return sub((VarM) v);
        return null;
    }

    public Var sub(VarF v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Вычитание со скаляром невозможно"));
        return null;
    }
    public Var sub(VarV v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Вычитание с вектором невозможно"));
        return null;
    }
    public Var sub(VarM v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Вычитание с матрицей невозможно"));
        return null;
    }

    @Override
    public Var mul(Var v) {
        if (v instanceof VarF) return mul((VarF) v);
        if (v instanceof VarV) return mul((VarV) v);
        if (v instanceof VarM) return mul((VarM) v);
        return null;
    }

    public Var mul(VarF v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Перемножение со скаляром невозможно"));
        return null;
    }
    public Var mul(VarV v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Перемножение с вектором невозможно"));
        return null;
    }
    public Var mul(VarM v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Перемножение с матрицей невозможно"));
        return null;
    }

    @Override
    public Var div(Var v) {
        if (v instanceof VarF) return div((VarF) v);
        if (v instanceof VarV) return div((VarV) v);
        if (v instanceof VarM) return div((VarM) v);
        return null;
    }

    public Var div(VarF v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Деление со скаляром невозможно"));
        return null;
    }
    public Var div(VarV v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Деление с вектором невозможно"));
        return null;
    }
    public Var div(VarM v){
        Logger.getInstance().errorPrinter(new IllegalArgumentException("Деление с матрицей невозможно"));
        return null;
    }

    @Override
    public void assigned(String name, Var var) {
       HashMapper.setVeriable(name, var);
    }
}
