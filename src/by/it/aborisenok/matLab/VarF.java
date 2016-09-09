package by.it.aborisenok.matLab;

/**
 * Created by Лёша on 09.09.2016.
 */
public class VarF extends Var{

    private double value;

    public VarF(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public Var add(VarF v) {
        return new VarF(this.value + v.getValue());
    }

    @Override
    public Var add(VarV v) {
        return v.add(this);
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }

    @Override
    public Var add(VarM v) {

        return v.add(this);
    }
}
