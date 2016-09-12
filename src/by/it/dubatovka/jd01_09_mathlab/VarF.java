package by.it.dubatovka.jd01_09_mathlab;

/**
 * Created by user on 09.09.2016.
 */
public class VarF extends Var {
    public double value;


    public VarF(double value) {
        this.value=value;
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }


    @Override
    public Var add(VarF v) {
        return new VarF(this.value+v.value);
    }

    @Override
    public Var add(VarV v) {
        return v.add(this);
    }
}
