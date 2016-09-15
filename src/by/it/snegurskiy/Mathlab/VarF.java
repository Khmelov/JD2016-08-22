package by.it.snegurskiy.Mathlab;

/**
 * Created by user on 09.09.2016.
 */
public class VarF extends Var {
    public double value;

    public VarF(double value) {
        this.value=value;
    }


    @Override
    public Var add(VarF v) {
        return new VarF(this.value+v.value);
    }

    public Var sub (VarF v) {
        return new VarF(this.value-v.value);
    }

    public Var mul(VarF v) {
        return new VarF(this.value*v.value);
    }

    public Var div(VarF v) {
        return new VarF(this.value/v.value);
    }



    @Override
    public String toString() {
        return ((Double)value).toString();
    }

    @Override
    public Var add(VarV v) {
        return v.add(this);
    }

    public Var add(VarM v) {return v.add(this);}



}
