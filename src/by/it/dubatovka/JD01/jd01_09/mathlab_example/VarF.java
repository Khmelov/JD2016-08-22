package by.it.dubatovka.JD01.jd01_09.mathlab_example;

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
